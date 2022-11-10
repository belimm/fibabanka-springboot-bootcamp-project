package com.project.shopping.service;

import com.project.shopping.dto.CartProductDto;
import org.springframework.http.ResponseEntity;

public interface ICartProductService {
    ResponseEntity<?> addCartProduct(CartProductDto cartProductDto);
}
