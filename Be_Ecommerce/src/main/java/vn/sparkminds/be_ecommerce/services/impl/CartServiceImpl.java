package vn.sparkminds.be_ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.Cart;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.repositories.CartRepository;
import vn.sparkminds.be_ecommerce.services.CartItemService;
import vn.sparkminds.be_ecommerce.services.CartService;
import vn.sparkminds.be_ecommerce.services.dto.request.AddItemRequest;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    private CartItemService cartItemService;
    @Override
    public Cart createCart(User user) {
        return null;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        return null;
    }

    @Override
    public Cart findUserCart(Long userId) {
        return null;
    }
}
