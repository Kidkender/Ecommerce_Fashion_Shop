package vn.sparkminds.be_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sparkminds.be_ecommerce.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
