package vn.sparkminds.be_ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.Address;
import vn.sparkminds.be_ecommerce.entities.Order;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.OrderException;
import vn.sparkminds.be_ecommerce.repositories.CartRepository;
import vn.sparkminds.be_ecommerce.repositories.OrderService;
import vn.sparkminds.be_ecommerce.services.CartService;
import vn.sparkminds.be_ecommerce.services.ProductService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartService cartItemService;
    @Autowired
    private ProductService productService;

    @Override
    public void deleteOrder(Long orderId) throws OrderException {

    }

    @Override
    public Order createOrder(User user, Address shipAddress) {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }
}
