package vn.sparkminds.be_ecommerce.repositories;

import vn.sparkminds.be_ecommerce.entities.Address;
import vn.sparkminds.be_ecommerce.entities.Order;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.OrderException;

import java.util.List;

public interface OrderService {
    public void deleteOrder(Long orderId) throws OrderException;

    public Order createOrder(User user, Address shipAddress);

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long orderId) throws OrderException;

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;

    public List<Order> getAllOrders();

}
