package com.project.shopping.controller;

import com.project.shopping.dto.CartProductDto;

import com.project.shopping.service.CartProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author berklimoncu
 */
@RestController
@RequestMapping("/shopping")
public class CartProductController {

    private final CartProductService cartProductService;

    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    /** HTTP Method -- URI
     *  POST         -- http://localhost:8082/shopping/cart/add
     *               -- Add CartProduct request type as ProductDto response type as ProductDto
     */
    @PostMapping("/cart/add")
    public ResponseEntity<?> addCartProduct(@RequestBody CartProductDto cartProductDto){
       return cartProductService.addCartProduct(cartProductDto);
    }
}
