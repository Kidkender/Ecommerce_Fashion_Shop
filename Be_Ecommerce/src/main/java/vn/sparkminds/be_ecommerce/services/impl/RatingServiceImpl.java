package vn.sparkminds.be_ecommerce.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.entities.Rating;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.exceptions.RatingException;
import vn.sparkminds.be_ecommerce.repositories.RatingRepository;
import vn.sparkminds.be_ecommerce.services.ProductService;
import vn.sparkminds.be_ecommerce.services.RatingService;
import vn.sparkminds.be_ecommerce.services.dto.request.ratingRequest;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ProductService productService;


    @Override
    public Rating createRating(ratingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Long ratingId) throws RatingException {
        Optional<Rating> opt = ratingRepository.findById(ratingId);
        if (opt.isPresent()) {
            ratingRepository.deleteById(ratingId);
        } ;
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }



}
