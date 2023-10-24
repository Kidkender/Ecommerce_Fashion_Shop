package vn.sparkminds.be_ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.services.ProductService;
import vn.sparkminds.be_ecommerce.services.dto.request.CreateProductRequest;
import vn.sparkminds.be_ecommerce.services.dto.response.ApiResponse;

@RestController
@RequestMapping("/api/admin/products")
@Tag(name = "Product managerment ", description = "CRUD product, multiple product")
public class AdminProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    @Operation(summary = "Create product")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req) {
        Product product = productService.createProduct(req);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}/delete")
    @Operation(summary = "Delete a product by id", description = "product must exist")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId)
            throws ProductException {
        productService.deleteProduct(productId);
        ApiResponse response = new ApiResponse();
        response.setMessage("produc deleted successfully");
        response.setStatus(true);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}/update")
    @Operation(summary = "update product", description = "Product must exist")
    public ResponseEntity<Product> updateProduct(@RequestBody Product req,
            @PathVariable Long productId) throws ProductException {
        Product product = productService.updateProduct(productId, req);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @PostMapping("/creates")
    @Operation(summary = "Create multiple product")
    public ResponseEntity<ApiResponse> createMultiProduct(@RequestBody CreateProductRequest[] req) {
        for (CreateProductRequest product : req) {
            productService.createProduct(product);
        }
        ApiResponse response = new ApiResponse();
        response.setMessage("Multi product created successfully");
        response.setStatus(true);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);
    }
}
