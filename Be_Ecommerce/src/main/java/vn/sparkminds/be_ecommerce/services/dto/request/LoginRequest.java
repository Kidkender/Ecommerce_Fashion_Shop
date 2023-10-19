package vn.sparkminds.be_ecommerce.services.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginRequest {
    String email;
    String password;
}
