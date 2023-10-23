package vn.sparkminds.be_ecommerce.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.entities.Review;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.repositories.ReviewRepository;
import vn.sparkminds.be_ecommerce.services.ProductService;
import vn.sparkminds.be_ecommerce.services.ReviewService;
import vn.sparkminds.be_ecommerce.services.dto.request.reviewRequest;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductService productService;

    // @Autowired
    // private ProductRepository productRepository;


    @Override
    public Review createReview(reviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());
        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews(Long productId) {


        return reviewRepository.getAllProductsReview(productId);
    }

}
