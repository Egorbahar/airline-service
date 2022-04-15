package com.godeltech.facade.impl;

import com.godeltech.facade.AirplaneFacade;
import com.godeltech.mapper.AirplaneMapper;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.service.AirplaneService;
import com.godeltech.service.CategoryService;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AirplaneFacadeImpl implements AirplaneFacade {
    private final AirplaneService airplaneService;
    private final CategoryService categoryService;
    private final AirplaneMapper airplaneMapper;


    @Override
    public AirplaneResponseDto findById(Long id) {
        return airplaneMapper.toAirplaneResponseDto(airplaneService.findById(id));
    }

    @Override
    public List<AirplaneResponseDto> findAll() {
        return airplaneMapper.toAirplaneResponseDtoList(airplaneService.findAll());
    }

    @Override
    public AirplaneResponseDto save(AirplaneRequestDto airplaneRequestDto) {
        Airplane airplane = airplaneMapper.toAirplane(airplaneRequestDto);
        airplane.setCategory(categoryService.findById(airplaneRequestDto.getCategoryId()));
        return airplaneMapper.toAirplaneResponseDto(airplaneService.save(airplane));
    }

    @Override
    public AirplaneResponseDto update(Long id, AirplaneRequestDto airplaneRequestDto) {
        Airplane airplane = airplaneService.findById(id);
        airplaneMapper.updateEntity(airplane,airplaneRequestDto);
        return airplaneMapper.toAirplaneResponseDto(airplaneService.update(airplane));
    }

    @Override
    public void deleteById(Long id) {
        airplaneService.deleteById(id);
    }
}
