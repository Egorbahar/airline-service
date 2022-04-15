package com.godeltech.service;

import com.godeltech.persistence.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    Category save(Category category);

    List<Category> findAll();

    Category update(Category category);

    void deleteById(Long id);
}
