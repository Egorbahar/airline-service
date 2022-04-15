package com.godeltech.facade;

import com.godeltech.web.dto.request.CategoryRequestDto;
import com.godeltech.web.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryFacade {
    CategoryResponseDto findById(Long id);

    List<CategoryResponseDto> findAll();

    CategoryResponseDto save(CategoryRequestDto categoryRequestDto);

    CategoryResponseDto update(Long id, CategoryRequestDto categoryRequestDto);

    void deleteById(Long id);
}

