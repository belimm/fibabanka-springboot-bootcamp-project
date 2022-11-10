package com.project.commerce.controller;

import com.project.commerce.dto.shopping.CartProductDto;
import com.project.commerce.service.ShoppingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author berklimoncu
 */
@Controller
@RequestMapping("/commerce/shopping")
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8080/commerce/shopping/cart/create
     *              -- Create a new Cart and response type as Integer with cartId
     */
    @GetMapping("/cart/create")
    @ResponseBody
    public ResponseEntity<?> createCart(@RequestHeader(value = "customer-name") String customerName){
        return shoppingService.createCart(customerName);
    }

    /** HTTP Method -- URI
     *  POST         -- http://localhost:8080/commerce/shopping/cart/add
     *               -- Add CartProduct request type as ProductDto response type as ProductDto
     */
    @PostMapping("/cart/add")
    @ResponseBody
    public ResponseEntity<?> addCartProduct(@RequestBody CartProductDto cartProductDto){
        return shoppingService.addCartProduct(cartProductDto);
    }

    /** HTTP Method -- URI
     *  DELETE      -- http://localhost:8080/commerce/shopping/cart/{cartId}/remove/{productId}
     *              -- Remove CartProduct by ProductId response type as String
     */
    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    @ResponseBody
    public ResponseEntity<?>  removeCartProductFromCartByProductId(
            @PathVariable("cartId") Long cartId,
            @PathVariable("productId") Long productId
    ){
        return shoppingService.removeCartProductFromCartByProductId(cartId, productId);
    }

    /** HTTP Method -- URI
     *  GET         -- http://localhost:8080/commerce/shopping/checkout/{cartId}
     *              -- Change cartStatus(from 0 to 1) from Cart by cartId response type as CartDto
     */
    @GetMapping("/checkout/{cartId}")
    @ResponseBody
    public ResponseEntity<?> checkOutByCartId(@PathVariable("cartId") Long cartId){
        return shoppingService.checkOutByCartId(cartId);
    }
    /** HTTP Method -- URI
     *  Get         -- http://localhost:8080/commerce/shopping/cart/find?cartId={cartId}
     *              -- FindCart by cartId
     */
    @GetMapping("/cart/find")
    @ResponseBody
    public ResponseEntity<?> findCart(@RequestParam(value = "cartId") Long cartId){
        return shoppingService.findCart(cartId);
    }
}
