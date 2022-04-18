package com.godeltech.facade;

import com.godeltech.web.dto.request.CategoryRequestDto;
import com.godeltech.web.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryFacade {
    CategoryResponseDto findById(final Long id);

    List<CategoryResponseDto> findAll();

    CategoryResponseDto save(final CategoryRequestDto categoryRequestDto);

    CategoryResponseDto update(final Long id,final CategoryRequestDto categoryRequestDto);

    void deleteById(final Long id);
}

