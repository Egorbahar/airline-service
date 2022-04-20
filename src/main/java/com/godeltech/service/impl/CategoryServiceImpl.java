package com.godeltech.service.impl;

import com.godeltech.persistence.model.Category;
import com.godeltech.persistence.repository.CategoryRepository;
import com.godeltech.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(final Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Category save(final Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category update(final Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        categoryRepository.deleteById(id);
    }
}
