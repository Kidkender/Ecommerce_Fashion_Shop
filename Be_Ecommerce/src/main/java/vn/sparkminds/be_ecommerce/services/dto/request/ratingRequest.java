package vn.sparkminds.be_ecommerce.services.dto.request;

public class ratingRequest {
    private Long productId;
    private double Rating;

    public ratingRequest(Long productId, double rating) {
        this.productId = productId;
        Rating = rating;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }
}
