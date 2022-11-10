package com.project.inventory.service;

import com.project.inventory.entity.Category;
import org.springframework.http.ResponseEntity;


public interface ICategoryService {
    public ResponseEntity<?> getAllCategories();

    public ResponseEntity<?> getCategoryById(Long categoryId);

    public ResponseEntity<?> addCategory(Category category);
}
