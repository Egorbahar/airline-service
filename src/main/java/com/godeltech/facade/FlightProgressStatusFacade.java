package com.godeltech.facade;

import com.godeltech.web.dto.request.FlightProgressStatusRequestDto;
import com.godeltech.web.dto.response.FlightProgressStatusResponseDto;

import java.util.List;

public interface FlightProgressStatusFacade {
    FlightProgressStatusResponseDto findById(final Long id);

    List<FlightProgressStatusResponseDto> findAll();

    FlightProgressStatusResponseDto update(final Long id, final FlightProgressStatusRequestDto flightProgressStatusRequestDto);

    FlightProgressStatusResponseDto save(final FlightProgressStatusRequestDto flightProgressStatusRequestDto);

    void deleteById(final Long id);
}
