package vn.sparkminds.be_ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.OrderItem;
import vn.sparkminds.be_ecommerce.exceptions.OrderItemException;
import vn.sparkminds.be_ecommerce.repositories.OrderItemRepository;
import vn.sparkminds.be_ecommerce.services.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) throws OrderItemException {
        if (orderItem != null) {
            OrderItem createdItem = orderItemRepository.save(orderItem);
            return createdItem;
        }
        throw new OrderItemException("invalid create order item");
    }


}
