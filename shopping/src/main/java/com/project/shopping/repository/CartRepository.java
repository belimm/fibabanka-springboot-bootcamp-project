package com.project.shopping.repository;

import com.project.shopping.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart getCartByCustomerName(String customerName);
}
