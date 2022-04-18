package com.godeltech.facade;

import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;

import java.util.List;

public interface AirplaneFacade {
    AirplaneResponseDto findById(final Long id);

    List<AirplaneResponseDto> findAll();

    AirplaneResponseDto save(final AirplaneRequestDto airplaneRequestDto);

    AirplaneResponseDto update(final Long id, final AirplaneRequestDto airplaneRequestDto);

    void deleteById(final Long id);
}
