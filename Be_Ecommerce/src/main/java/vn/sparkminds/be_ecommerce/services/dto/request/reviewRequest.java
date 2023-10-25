package vn.sparkminds.be_ecommerce.services.dto.request;

public class reviewRequest {
    private Long productId;
    private String review;

    public reviewRequest(Long productId, String review) {
        this.productId = productId;
        this.review = review;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
