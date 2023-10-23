package vn.sparkminds.be_ecommerce.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.sparkminds.be_ecommerce.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("Select r from rating r where r.product.id =:productId")
    public List<Rating> getAllProductsRating(@Param("productId") Long productId);

}