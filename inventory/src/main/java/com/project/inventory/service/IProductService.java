package com.project.inventory.service;

import com.project.inventory.dto.ProductDto;
import org.springframework.http.ResponseEntity;

public interface IProductService {
   ResponseEntity<?> getAllProducts();
    ResponseEntity<?> addProduct(ProductDto product);
    ResponseEntity<?> getProductById(Long productId);
    ResponseEntity<?> getProductsByCategoryId(Long categoryId);

    ResponseEntity<?> findByProductName(String productName);
}
