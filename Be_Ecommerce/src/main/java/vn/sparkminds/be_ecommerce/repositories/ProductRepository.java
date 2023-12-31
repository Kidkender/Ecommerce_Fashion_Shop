package vn.sparkminds.be_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.sparkminds.be_ecommerce.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product  p where (p.category.name=:category or " +
            ":category='') and ((:minPrice is null  and :maxPrice is null) or" +
            " (p.discountedPrice BETWEEN  :minPrice and :maxPrice)) and " +
            "(:minDiscount is null or p.discountPersent >= :minDiscount) " +
            "order by " +
            "case when :sort = 'price_low' then p.discountedPrice end asc, " +
            "case when :sort = 'price_high' then p.discountedPrice end desc")
    public List<Product> filterProducts(
            @Param("category") String category,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            @Param("minDiscount") Integer minDiscount,
            @Param("sort") String sort
    );
}
