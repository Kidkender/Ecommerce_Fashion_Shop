package vn.sparkminds.be_ecommerce.services.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String jwt;
    private String message;

}
