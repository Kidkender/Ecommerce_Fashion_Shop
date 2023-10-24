package vn.sparkminds.be_ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import vn.sparkminds.be_ecommerce.entities.Order;
import vn.sparkminds.be_ecommerce.exceptions.OrderException;
import vn.sparkminds.be_ecommerce.services.OrderService;


@RestController
@RequestMapping("/api/admin/orders")
@Tag(name = "Managerment order by Admin", description = "Change status of order")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    @Operation(description = "Get all orders in system")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }


    @PutMapping("/{orderId}/confirm")
    @Operation(summary = "Confirm status order", description = "Order must exist")
    @ApiResponse(responseCode = "400", description = "Confirm successfully")
    public ResponseEntity<Order> confirmedOrder(@PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {

        Order order = orderService.confirmedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/deliver")
    @Operation(summary = "Change status order to deliver")
    public ResponseEntity<Order> deliverOrder(@PathVariable Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/ship")
    @Operation(summary = "Change status order to shipped")
    public ResponseEntity<Order> shippedOrder(@PathVariable("orderId") Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {

        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancel")
    @Operation(summary = "Change status order to cancel")
    public ResponseEntity<Order> cancelledOrder(@PathVariable("orderId") Long orderId,
            @RequestHeader("Authorization") String jwt) throws OrderException {

        Order order = orderService.canceledOrder(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }


}
