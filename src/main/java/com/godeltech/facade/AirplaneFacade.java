package com.godeltech.facade;

import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;

import java.util.List;

public interface AirplaneFacade {
    AirplaneResponseDto findById(Long id);

    List<AirplaneResponseDto> findAll();

    AirplaneResponseDto save(AirplaneRequestDto airplaneRequestDto);

    AirplaneResponseDto update(Long id, AirplaneRequestDto airplaneRequestDto);

    void deleteById(Long id);
}
