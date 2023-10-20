package vn.sparkminds.be_ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.Cart;
import vn.sparkminds.be_ecommerce.entities.CartItem;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.CartItemException;
import vn.sparkminds.be_ecommerce.exceptions.UserException;
import vn.sparkminds.be_ecommerce.repositories.CartItemRepository;
import vn.sparkminds.be_ecommerce.repositories.CartRepository;
import vn.sparkminds.be_ecommerce.services.CartItemService;
import vn.sparkminds.be_ecommerce.services.UserService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);

        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        CartItem item=findCartItemById(id);
        User user=userService.findUserById(item.getUserId());
        if (user.getId().equals(userId)){
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
        }

        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        return null;
    }
}
