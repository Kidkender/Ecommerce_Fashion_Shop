package vn.sparkminds.be_ecommerce.services;

import vn.sparkminds.be_ecommerce.entities.Cart;
import vn.sparkminds.be_ecommerce.entities.CartItem;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.exceptions.CartItemException;
import vn.sparkminds.be_ecommerce.exceptions.UserException;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String size,
                                    Long userId);

    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
    public CartItem findCartItemById(Long cartItemId) throws CartItemException;


}
