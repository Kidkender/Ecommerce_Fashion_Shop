package vn.sparkminds.be_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.sparkminds.be_ecommerce.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("Select c form cart c where c.user.id=:userId")
    public Cart findUserById(@Param("userId") Long userId);
}
