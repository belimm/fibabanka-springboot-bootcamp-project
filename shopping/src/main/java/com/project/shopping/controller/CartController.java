package com.project.shopping.controller;


import com.project.shopping.dto.CartDto;
import com.project.shopping.entity.Cart;

import com.project.shopping.service.CartService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author berklimoncu
 */
@RestController
@RequestMapping("/shopping")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8082/shopping/cart/create
     *              -- Create a new Cart and response type as Integer with cartId
     */
    @GetMapping("/cart/create")
    public ResponseEntity<?> createCart(@RequestHeader(value = "customer-name") String customerName){
        return cartService.createCart(customerName);
    }

    /** HTTP Method -- URI
     *  DELETE      -- http://localhost:8082/shopping/cart/{cartId}/remove/{productId}
     *              -- Remove CartProduct by ProductId response type as String
     */
    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> removeCartProductFromCartByProductId(
            @PathVariable("cartId") Long cartId,
            @PathVariable("productId") Long productId
    ){
       return cartService.removeCartProductFromCartByProductId(cartId, productId);
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8082/shopping/checkout/{cartId}
     *              -- Change cartStatus(from 0 to 1) from Cart by cartId response type as CartDto
     */
    @GetMapping("/checkout/{cartId}")
    public ResponseEntity<?> checkOutByCartId(@PathVariable("cartId") Long cartId){
       return cartService.checkOutByCartId(cartId);
    }

    /** HTTP Method -- URI
     *  Get         -- http://localhost:8082/shopping/cart/find?cartId={cartId}
     *              -- FindCart by cartId
     */
    @GetMapping("/cart/find")
    public ResponseEntity<?> findCart(@RequestParam(value = "cartId") Long cartId){
        return cartService.findCart(cartId);
    }
}
