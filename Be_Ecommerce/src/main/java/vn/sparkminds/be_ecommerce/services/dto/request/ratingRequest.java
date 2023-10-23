package vn.sparkminds.be_ecommerce.services.dto.request;

import lombok.Data;

@Data
public class ratingRequest {
    private Long productId;
    private double Rating;
}
