package com.godeltech.facade;

import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;

import java.util.List;

public interface FlightFacade {
    FlightResponseDto findById(Long id);

    List<FlightResponseDto> findAll();

    FlightResponseDto save(FlightRequestDto flightRequestDto);

    FlightResponseDto update(Long id, FlightRequestDto flightRequestDto);

    FlightResponseDto updateFlightStartStatus(Long modelId, Long statusId);

    FlightResponseDto updateFlightProgressStatus(Long modelId, Long statusId);

    void deleteById(Long id);
}
