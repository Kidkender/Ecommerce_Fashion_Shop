package vn.sparkminds.be_ecommerce.services.dto.request;

import lombok.Getter;
import lombok.Setter;
import vn.sparkminds.be_ecommerce.entities.Size;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class CreateProductRequest {
    private String title;
    private String description;
    private int price;
    private int discountedPrice;
    private int discountPersent;
    private int quantity;
    private String brand;
    private String color;
    private Set<Size> size=new HashSet<>();
    private String imageUrl;
    private String topLavelCategory;
    private String secondLavelCategory;
    private String thirdLavelCategory;

}
