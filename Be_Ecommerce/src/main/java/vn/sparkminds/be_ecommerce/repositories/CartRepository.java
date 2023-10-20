package vn.sparkminds.be_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sparkminds.be_ecommerce.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

}
