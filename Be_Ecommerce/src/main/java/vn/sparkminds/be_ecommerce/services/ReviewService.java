package vn.sparkminds.be_ecommerce.services;

import java.util.List;
import vn.sparkminds.be_ecommerce.entities.Review;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.services.dto.request.reviewRequest;

public interface ReviewService {
    public Review createReview(reviewRequest req, User user) throws ProductException;

    public List<Review> getAllReviews(Long productId);

}
