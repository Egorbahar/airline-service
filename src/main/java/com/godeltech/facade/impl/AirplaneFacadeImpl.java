package com.godeltech.facade.impl;

import com.godeltech.facade.AirplaneFacade;
import com.godeltech.mapper.AirplaneMapper;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.service.AirplaneService;
import com.godeltech.service.CategoryService;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class AirplaneFacadeImpl implements AirplaneFacade {
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
        Airplane airplane = airplaneMapper.toAirplane(airplaneRequestDto);
        airplane.setCategory(categoryService.findById(airplaneRequestDto.getCategoryId()));
        return airplaneMapper.toAirplaneResponseDto(airplaneService.save(airplane));
    }

    @Override
    public AirplaneResponseDto update(final Long id,final AirplaneRequestDto airplaneRequestDto) {
        log.debug("Update airplane with id:{}", id);
        Airplane airplane = airplaneService.findById(id);
        airplaneMapper.updateEntity(airplane,airplaneRequestDto);
        return airplaneMapper.toAirplaneResponseDto(airplaneService.update(airplane));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete airplane with id:{}", id);
        airplaneService.deleteById(id);
    }
}
