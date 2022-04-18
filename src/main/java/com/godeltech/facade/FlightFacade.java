package com.godeltech.facade;

import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;

import java.util.List;

public interface FlightFacade {
    FlightResponseDto findById(final Long id);

    List<FlightResponseDto> findAll();

    FlightResponseDto save(final FlightRequestDto flightRequestDto);

    FlightResponseDto update(final Long id, final FlightRequestDto flightRequestDto);

    FlightResponseDto updateFlightStartStatus(final Long modelId, final Long statusId);

    FlightResponseDto updateFlightProgressStatus(final Long modelId, final Long statusId);

    void deleteById(final Long id);
}
