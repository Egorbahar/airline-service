package com.godeltech.facade;

import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;

import java.util.List;

public interface FlightStartStatusFacade {
    FlightStartStatusResponseDto findById(final Long id);

    List<FlightStartStatusResponseDto> findAll();

    FlightStartStatusResponseDto save(final FlightStartStatusRequestDto flightStartStatusRequestDto);

    FlightStartStatusResponseDto update(final Long id, final FlightStartStatusRequestDto flightStartStatusRequestDto);

    void deleteById(final Long id);
}
