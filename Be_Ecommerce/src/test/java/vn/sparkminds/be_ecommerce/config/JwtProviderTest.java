package vn.sparkminds.be_ecommerce.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class JwtProviderTest {
    private JwtProvider jwtProvider;

    @BeforeEach
    public void setup() {
        jwtProvider = new JwtProvider();
    }

    @Test
    public void testGenerateToken() {
        Authentication auth = new UsernamePasswordAuthenticationToken("test@gmail.com", "123");
        String token = jwtProvider.generateToken(auth);
        assertNotNull(token);
    }

    @Test
    public void testGetEmailFromToken() {
        String token = jwtProvider.generateToken(
                new UsernamePasswordAuthenticationToken("test@gmail.com", "password"));
        token = "Bearer ".concat(token);
        String email = jwtProvider.getEmailFromToken(token);
        assertEquals("test@gmail.com", email);
    }
}
