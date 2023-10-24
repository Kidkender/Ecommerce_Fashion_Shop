package vn.sparkminds.be_ecommerce.services;

import vn.sparkminds.be_ecommerce.entities.OrderItem;
import vn.sparkminds.be_ecommerce.exceptions.OrderItemException;

public interface OrderItemService {
    public OrderItem createOrderItem(OrderItem orderItem) throws OrderItemException;
}
