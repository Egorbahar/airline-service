package com.godeltech.facade.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.AssignmentException;
import com.godeltech.facade.AirplaneFacade;
import com.godeltech.mapper.AirplaneMapper;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.model.Category;
import com.godeltech.service.AirplaneService;
import com.godeltech.service.CategoryService;
import com.godeltech.service.FlightService;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class AirplaneFacadeImpl implements AirplaneFacade {
    private final FlightService flightService;
    private final LocalMessageSource messageSource;
    private final AirplaneService airplaneService;
    private final CategoryService categoryService;
    private final AirplaneMapper airplaneMapper;



    @Override
    public AirplaneResponseDto findById(final Long id) {
        log.debug("Find airplane with id:{}", id);
        return airplaneMapper.toAirplaneResponseDto(airplaneService.findById(id));
    }

    @Override
    public List<AirplaneResponseDto> findAll() {
        log.debug("Find all airplanes");
        return airplaneMapper.toAirplaneResponseDtoList(airplaneService.findAll());
    }

    @Override
    public AirplaneResponseDto save(final AirplaneRequestDto airplaneRequestDto) {
        log.debug("Save airplane");
        final Airplane airplane = airplaneMapper.toAirplane(airplaneRequestDto);
        airplane.setCategory(categoryService.findById(airplaneRequestDto.getCategoryId()));
        return airplaneMapper.toAirplaneResponseDto(airplaneService.save(airplane));
    }

    @Override
    public AirplaneResponseDto update(final Long id,final AirplaneRequestDto airplaneRequestDto) {
        log.debug("Update airplane with id:{}", id);
        final Airplane airplane = airplaneService.findById(id);
        final Category category = categoryService.findById(airplaneRequestDto.getCategoryId());
        airplaneMapper.updateEntity(airplane,airplaneRequestDto,category);
        return airplaneMapper.toAirplaneResponseDto(airplaneService.update(airplane));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete airplane with id:{}", id);
        final boolean isAssignedToFlight = flightService.findAll().stream()
                .map(flight -> flight.getPlane().getId())
                .collect(Collectors.toList())
                .contains(id);
        if (isAssignedToFlight) {
            throw new AssignmentException(messageSource.getMessage("error.record.isAssignment", new Object[]{}));
        } else {
            airplaneService.deleteById(id);
        }

    }
}
