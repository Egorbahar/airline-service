package com.godeltech.facade;

import com.godeltech.web.dto.request.AirportRequestDto;
import com.godeltech.web.dto.response.AirportResponseDto;

import java.util.List;

public interface AirportFacade {
    AirportResponseDto findById(Long id);

    List<AirportResponseDto> findAll();

    AirportResponseDto save(AirportRequestDto airportRequestDto);

    AirportResponseDto update(Long id, AirportRequestDto airportRequestDto);

    void deleteById(Long id);
}
