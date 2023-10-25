package vn.sparkminds.be_ecommerce.services;

import java.util.List;
import vn.sparkminds.be_ecommerce.entities.Rating;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.exceptions.RatingException;
import vn.sparkminds.be_ecommerce.services.dto.request.ratingRequest;

public interface RatingService {
    public Rating createRating(ratingRequest req, User user) throws ProductException;

    public List<Rating> getProductsRating(Long productId);

    public void deleteRating(Long ratingId) throws RatingException;

}
