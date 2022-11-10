package com.project.commerce.service;

import com.project.commerce.dto.inventory.CategoryDto;
import com.project.commerce.dto.inventory.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class InventoryService {

    private final RestTemplate restTemplate;

    public InventoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> getAllCategories(){
        String uri = "http://localhost:8081/inventory/categories";

        List<CategoryDto> categories = restTemplate.getForObject(uri, List.class);

        return ResponseEntity
                .ok()
                .body(categories);
    }

    public ResponseEntity<?> getProductsByCategoryId(Long categoryId) {
        if(categoryId<=0) { //In case of invalid categoryId
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid ID");
        }

        String uri = String.format("http://localhost:8081/inventory/products/%s",categoryId);

        List<ProductDto> products = restTemplate.getForObject(uri, List.class);

        return ResponseEntity
                .ok()
                .body(products);
    }

    public ResponseEntity<?> getProductById(Long productId) {
        if(productId<=0) { //In case of invalid categoryId
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid ID");
        }

        String uri = String.format("http://localhost:8081/inventory/product/%s",productId);

        try{
            ProductDto product = restTemplate.getForObject(uri, ProductDto.class);

            return ResponseEntity
                    .ok()
                    .body(product);
        }
        catch (HttpStatusCodeException e ){ //If there is no product
            if(Objects.requireNonNull(e.getMessage()).contains("There is no product")){
                return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong!");
        }
    }
}
