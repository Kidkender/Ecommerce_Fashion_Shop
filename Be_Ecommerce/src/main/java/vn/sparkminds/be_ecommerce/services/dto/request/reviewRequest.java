package vn.sparkminds.be_ecommerce.services.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reviewRequest {
    private Long productId;
    private String review;
}
