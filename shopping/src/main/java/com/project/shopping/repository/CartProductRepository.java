package com.project.shopping.repository;

import com.project.shopping.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
}
