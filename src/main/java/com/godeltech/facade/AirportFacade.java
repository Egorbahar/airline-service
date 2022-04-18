package com.godeltech.facade;

import com.godeltech.web.dto.request.AirportRequestDto;
import com.godeltech.web.dto.response.AirportResponseDto;

import java.util.List;

public interface AirportFacade {
    AirportResponseDto findById(final Long id);

    List<AirportResponseDto> findAll();

    AirportResponseDto save(final AirportRequestDto airportRequestDto);

    AirportResponseDto update(final Long id,final AirportRequestDto airportRequestDto);

    void deleteById(final Long id);
}
