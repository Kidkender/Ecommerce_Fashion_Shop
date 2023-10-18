package vn.sparkminds.be_ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
public class PaymentInformation {
    @Column(name = "cardholder_name")
    private String cardholderName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "cvv")
    private String cvv;
}
