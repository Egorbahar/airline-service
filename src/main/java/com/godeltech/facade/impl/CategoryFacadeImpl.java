package com.godeltech.facade.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.AssignmentException;
import com.godeltech.facade.CategoryFacade;
import com.godeltech.mapper.CategoryMapper;
import com.godeltech.persistence.model.Category;
import com.godeltech.service.AirplaneService;
import com.godeltech.service.CategoryService;
import com.godeltech.service.FlightService;
import com.godeltech.web.dto.request.CategoryRequestDto;
import com.godeltech.web.dto.response.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CategoryFacadeImpl implements CategoryFacade {
    private final AirplaneService airplaneService;
    private final LocalMessageSource messageSource;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto findById(final Long id) {
        log.debug("Find category with id:{}", id);
        return categoryMapper.toCategoryResponseDto(categoryService.findById(id));
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        log.debug("Find all categories");
        return categoryMapper.toCategoryResponseDtoList(categoryService.findAll());
    }

    @Override
    public CategoryResponseDto save(final CategoryRequestDto categoryRequestDto) {
        log.debug("Save category");
        return categoryMapper.toCategoryResponseDto(categoryService.save(categoryMapper.toCategory(categoryRequestDto)));
    }

    @Override
    public CategoryResponseDto update(final Long id,final CategoryRequestDto categoryRequestDto) {
        log.debug("Update category with id:{}", id);
        final Category category = categoryService.findById(id);
        categoryMapper.updateEntity(category,categoryRequestDto);
        return categoryMapper.toCategoryResponseDto(categoryService.update(category));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete category with id:{}", id);
        final boolean isAssignedToFlight = airplaneService.findAll().stream()
                .map(flight -> flight.getCategory().getId())
                .collect(Collectors.toList())
                .contains(id);
        if (isAssignedToFlight) {
            throw new AssignmentException(messageSource.getMessage("error.record.isAssignment", new Object[]{}));
        } else {
            categoryService.deleteById(id);
        }
    }
}
