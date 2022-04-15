package com.godeltech.facade;

import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;

import java.util.List;

public interface FlightStartStatusFacade {
    FlightStartStatusResponseDto findById(Long id);

    List<FlightStartStatusResponseDto> findAll();

    FlightStartStatusResponseDto save(FlightStartStatusRequestDto flightStartStatusRequestDto);

    FlightStartStatusResponseDto update(Long id, FlightStartStatusRequestDto flightStartStatusRequestDto);

    void deleteById(Long id);
}
