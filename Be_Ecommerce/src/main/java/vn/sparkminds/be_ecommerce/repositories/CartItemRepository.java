package vn.sparkminds.be_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.sparkminds.be_ecommerce.entities.Cart;
import vn.sparkminds.be_ecommerce.entities.CartItem;
import vn.sparkminds.be_ecommerce.entities.Product;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("Select ci from CartItem ci Where ci.cart=:cart And  ci.product=:product and ci.size =:size and ci.userId=:userId")
    public CartItem isCartItemExists(@Param("cart") Cart cart, @Param("product") Product product,
            @Param("size") String size, @Param("userId") Long userId);
}
