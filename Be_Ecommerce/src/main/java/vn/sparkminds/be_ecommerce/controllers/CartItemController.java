package vn.sparkminds.be_ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import vn.sparkminds.be_ecommerce.entities.CartItem;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.CartItemException;
import vn.sparkminds.be_ecommerce.exceptions.UserException;
import vn.sparkminds.be_ecommerce.services.CartItemService;
import vn.sparkminds.be_ecommerce.services.UserService;
import vn.sparkminds.be_ecommerce.services.dto.response.ApiResponse;

@RestController
@RequestMapping("/api/v1/cartitem")
public class CartItemController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;


    @DeleteMapping("/{cartItemId}")
    @Operation(description = "Remove cart item from cart")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Delete item")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
            @RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Delete item from cart");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{cartItemId}")
    @Operation(description = "Update item to cart")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem,
            @PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt)
            throws CartItemException, UserException {
        User user = userService.findUserProfileByJwt(jwt);
        CartItem updateCartItem =
                cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
        return new ResponseEntity<>(updateCartItem, HttpStatus.OK);
    }
}
