package com.project.inventory.repository;

import com.project.inventory.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
