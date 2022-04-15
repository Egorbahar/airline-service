package com.godeltech.facade;

import com.godeltech.web.dto.request.FlightProgressStatusRequestDto;
import com.godeltech.web.dto.response.FlightProgressStatusResponseDto;

import java.util.List;

public interface FlightProgressStatusFacade {
    FlightProgressStatusResponseDto findById(Long id);

    List<FlightProgressStatusResponseDto> findAll();

    FlightProgressStatusResponseDto update(Long id, FlightProgressStatusRequestDto flightProgressStatusRequestDto);

    FlightProgressStatusResponseDto save(FlightProgressStatusRequestDto flightProgressStatusRequestDto);

    void deleteById(Long id);
}
