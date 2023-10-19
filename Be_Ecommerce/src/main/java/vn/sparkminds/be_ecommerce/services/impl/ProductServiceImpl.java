package vn.sparkminds.be_ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.Category;
import vn.sparkminds.be_ecommerce.entities.Product;
import vn.sparkminds.be_ecommerce.exceptions.ProductException;
import vn.sparkminds.be_ecommerce.repositories.CategoryRepository;
import vn.sparkminds.be_ecommerce.repositories.ProductRepository;
import vn.sparkminds.be_ecommerce.services.ProductService;
import vn.sparkminds.be_ecommerce.services.UserService;
import vn.sparkminds.be_ecommerce.services.dto.request.CreateProductRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(CreateProductRequest req) {
        Category topLevel = categoryRepository.findByName(req.getTopLavelCategory());
        if (topLevel == null) {
            Category topLavelCategory = new Category();
            topLavelCategory.setName(req.getTopLavelCategory());
            topLavelCategory.setLevel(1);

            topLevel = categoryRepository.save(topLavelCategory);

        }
        Category secondLevel =
                categoryRepository.findByNameAndParent(req.getSecondLavelCategory(), topLevel.getName());
        if (secondLevel == null) {
            Category secondLavelCategory = new Category();
            secondLavelCategory.setName(req.getSecondLavelCategory());
            secondLavelCategory.setParentCategory(topLevel);
            secondLavelCategory.setLevel(2);
            secondLevel = categoryRepository.save(secondLavelCategory);
        }


        Category thirdLevel =
                categoryRepository.findByNameAndParent(req.getThirdLavelCategory(), secondLevel.getName());
        if (thirdLevel == null) {
            Category thirdLavelCategory = new Category();
            thirdLavelCategory.setName(req.getThirdLavelCategory());
            thirdLavelCategory.setParentCategory(secondLevel);
            thirdLavelCategory.setLevel(3);
            thirdLevel = categoryRepository.save(thirdLavelCategory);
        }
        Product product = new Product();
        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setDescription(req.getDescription());
        product.setDiscountedPrice(req.getDiscountedPrice());
        product.setDiscountPersent(req.getDiscountPersent());
        product.setImageUrl(req.getImageUrl());
        product.setBrand(req.getBrand());
        product.setPrice(req.getPrice());
        product.setSizes(req.getSize());
        product.setQuantity(req.getQuantity());
        product.setCategory(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
//        System.out.println("Product " + product);
        return savedProduct;
    }

    @Override
    public String deleteProduct(Long productId) throws ProductException {
        Product product=findProductById(productId);
        product.getSizes().clear();
        productRepository.delete(product);
        return "Product deleted successfully";
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductException {
        return null;
    }

    @Override
    public Product findProductById(Long productId) throws ProductException {
        return null;
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return null;
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> color, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) {
        return null;
    }
}
