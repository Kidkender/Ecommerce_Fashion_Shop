package vn.sparkminds.be_ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.sparkminds.be_ecommerce.entities.Rating;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.exceptions.RatingException;
import vn.sparkminds.be_ecommerce.exceptions.UserException;
import vn.sparkminds.be_ecommerce.services.RatingService;
import vn.sparkminds.be_ecommerce.services.UserService;
import vn.sparkminds.be_ecommerce.services.dto.request.ratingRequest;
import vn.sparkminds.be_ecommerce.services.dto.response.ApiResponse;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {
    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody ratingRequest req,
            @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Rating rating = ratingService.createRating(req, user);
        return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating(@PathVariable Long productId,
            @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Rating> ratings = ratingService.getProductsRating(productId);
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<ApiResponse> deleteRating(@PathVariable Long productId,
            @RequestHeader("Authorization") String jwt) throws UserException, RatingException {
        User user = userService.findUserProfileByJwt(jwt);

        ratingService.deleteRating(productId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Delete rating successfully");
        res.setStatus(true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.OK);
    }

}
