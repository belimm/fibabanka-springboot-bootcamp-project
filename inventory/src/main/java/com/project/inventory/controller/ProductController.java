package com.project.inventory.controller;

import com.project.inventory.dto.ProductDto;
import com.project.inventory.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author berklimoncu
 */
@RestController
@RequestMapping("/inventory")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8081/inventory/products
     *              -- Get Products by productId response type as ProductDto
     */
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        return productService.getAllProducts();
    }

    /** HTTP Method -- URI
     *  PUT         -- http://localhost:8081/inventory/product
     *              -- Add a new product response type as List of ProductDto
     */
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping("/product")
    public ResponseEntity<?> findByProductName(@RequestParam("productName")  String productName){
        return productService.findByProductName(productName);
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8081/inventory/products/{categoryId}
     *              -- Get products with categoryId response type as List of ProductDto
     */
    @GetMapping("/products/{categoryId}")
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8081/inventory/product/{productId}
     *              -- Get products with productId response type as ProductDto
     */
    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId);
    }
}
