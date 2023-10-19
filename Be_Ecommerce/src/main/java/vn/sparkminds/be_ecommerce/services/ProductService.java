package vn.sparkminds.be_ecommerce.services;

import org.springframework.data.domain.Page;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.services.dto.request.CreateProductRequest;

import java.util.List;

public interface ProductService {
    public Product createProduct(CreateProductRequest req);

    public String deleteProduct(Long productId) throws ProductException;

    public Product updateProduct(Long productId, Product product) throws ProductException;

    public Product findProductById(Long productId) throws ProductException;

    public List<Product> findProductByCategory(String category);

    public Page<Product> getAllProduct(String category, List<String> color,
                                       List<String> sizes, Integer minPrice,
                                       Integer maxPrice, Integer minDiscount,
                                       String sort, String stock,
                                       Integer pageNumber, Integer pageSize);


}
