package com.godeltech.facade.impl;

import com.godeltech.facade.CategoryFacade;
import com.godeltech.mapper.CategoryMapper;
import com.godeltech.persistence.model.Category;
import com.godeltech.service.CategoryService;
import com.godeltech.web.dto.request.CategoryRequestDto;
import com.godeltech.web.dto.response.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryFacadeImpl implements CategoryFacade {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto findById(Long id) {
        return categoryMapper.toCategoryResponseDto(categoryService.findById(id));
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryMapper.toCategoryResponseDtoList(categoryService.findAll());
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto categoryRequestDto) {
        return categoryMapper.toCategoryResponseDto(categoryService.save(categoryMapper.toCategory(categoryRequestDto)));
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto categoryRequestDto) {
        Category category = categoryService.findById(id);
        categoryMapper.updateEntity(category,categoryRequestDto);
        return categoryMapper.toCategoryResponseDto(categoryService.update(category));
    }

    @Override
    public void deleteById(Long id) {
        categoryService.deleteById(id);
    }
}
