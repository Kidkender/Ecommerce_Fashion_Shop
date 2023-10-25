package vn.sparkminds.be_ecommerce.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import vn.sparkminds.be_ecommerce.entities.Order;
import vn.sparkminds.be_ecommerce.exceptions.OrderException;
import vn.sparkminds.be_ecommerce.repositories.OrderRepository;
import vn.sparkminds.be_ecommerce.services.OrderService;
import vn.sparkminds.be_ecommerce.services.dto.response.ApiResponse;
import vn.sparkminds.be_ecommerce.services.dto.response.PaymentLinkResponse;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Value("${razorpay.api.secret}")
    String apiSecret;
    @Value("${razorpay.api.key}")
    String apiKey;


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/{orderId}/paymentlink")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws RazorpayException, OrderException {
        Order order = orderService.findOrderById(orderId);
        try {
            RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", order.getTotalPrice() * 100);
            paymentLinkRequest.put("currency", "VND");

            JSONObject customer = new JSONObject();
            customer.put("name", order.getUser().getFirstName());
            customer.put("email", order.getUser().getEmail());
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("callback_url", "http://localhost:3000/payment/" + orderId);
            paymentLinkRequest.put("callback_method", "get");
            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            String paymentLinkId = payment.get("id");
            String paymentLinkurl = payment.get("short_url");

            PaymentLinkResponse res = new PaymentLinkResponse();
            res.setPayment_link_id(paymentLinkId);
            res.setPayment_link_url(paymentLinkurl);
            return new ResponseEntity<PaymentLinkResponse>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RazorpayException(e.getMessage());
        }
    }

    @GetMapping("/payment/redirect")
    public ResponseEntity<ApiResponse> redirect(@RequestParam(name = "payment_id") String paymentId,
            @RequestParam(name = "order_id") Long orderId)
            throws OrderException, RazorpayException {
        Order order = orderService.findOrderById(orderId);
        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
        try {
            Payment payment = razorpayClient.payments.fetch(paymentId);
            if (payment.get("status").equals("captured")) {
                order.getPaymentDetails().setPaymentId(paymentId);
                order.getPaymentDetails().setPaymentStatus("COMPLETED");
                order.setOrderStatus("PLACED");
                orderRepository.save(order);
            }
            ApiResponse res = new ApiResponse("Your order get placed", true);
            return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            // TODO: handle exception
            throw new RazorpayException(e.getMessage());
        }
    }
}
