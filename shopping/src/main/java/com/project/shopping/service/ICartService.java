package com.project.shopping.service;

import com.project.shopping.dto.CartDto;
import com.project.shopping.dto.CartProductDto;
import com.project.shopping.entity.Cart;
import org.springframework.http.ResponseEntity;

public interface ICartService {

    ResponseEntity<?> createCart(String customerName);

    ResponseEntity<?> removeCartProductFromCartByProductId(Long cartId, Long productId);

    ResponseEntity<?> checkOutByCartId(Long cartId);

    ResponseEntity<?> findCart(Long cartId);
}
