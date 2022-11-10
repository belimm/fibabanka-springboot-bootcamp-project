package com.project.commerce.controller;

import com.project.commerce.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author berklimoncu
 */
@Controller
@RequestMapping("/commerce/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8080/commerce/inventory/categories
     *              -- Get All Categories as response type as CategoryDto
     */
    @GetMapping("/categories")
    @ResponseBody
    public ResponseEntity<?> getAllCategories(){
        return inventoryService.getAllCategories();
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8080/commerce/inventory/products/{categoryId}
     *              -- Get products with categoryId response type as List of ProductDto
     */
    @GetMapping("/products/{categoryId}")
    @ResponseBody
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId){
        return inventoryService.getProductsByCategoryId(categoryId);
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8080/commerce/inventory/product/{productId}
     *              -- Get products with productId response type as ProductDto
     */
    @GetMapping("/product/{productId}")
    @ResponseBody
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long productId) {
        return inventoryService.getProductById(productId);
    }
}
