package com.godeltech.facade.impl;

import com.godeltech.facade.FlightProgressStatusFacade;
import com.godeltech.mapper.FlightProgressStatusMapper;
import com.godeltech.persistence.model.FlightProgressStatus;
import com.godeltech.service.FlightProgressStatusService;
import com.godeltech.web.dto.request.FlightProgressStatusRequestDto;
import com.godeltech.web.dto.response.FlightProgressStatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightProgressStatusFacadeImpl implements FlightProgressStatusFacade {
    private final FlightProgressStatusService flightProgressStatusService;
    private final FlightProgressStatusMapper flightProgressStatusMapper;

    @Override
    public FlightProgressStatusResponseDto findById(final Long id) {
        return flightProgressStatusMapper.toFlightProgressStatusResponseDto(flightProgressStatusService.findById(id));
    }

    @Override
    public List<FlightProgressStatusResponseDto> findAll() {
        return flightProgressStatusMapper.toFlightProgressStatusResponseDtoList(flightProgressStatusService.findAll());
    }

    @Override
    public FlightProgressStatusResponseDto save(final FlightProgressStatusRequestDto flightProgressStatusRequestDto) {
        return flightProgressStatusMapper.toFlightProgressStatusResponseDto(flightProgressStatusService.save(flightProgressStatusMapper.toFlightProgressStatus(flightProgressStatusRequestDto)));
    }

    @Override
    public FlightProgressStatusResponseDto update(final Long id, final FlightProgressStatusRequestDto flightProgressStatusRequestDto) {
        FlightProgressStatus flightProgressStatus = flightProgressStatusService.findById(id);
        flightProgressStatusMapper.updateEntity(flightProgressStatus, flightProgressStatusRequestDto);
        return flightProgressStatusMapper.toFlightProgressStatusResponseDto(flightProgressStatusService.update(flightProgressStatus));
    }

    @Override
    public void deleteById(final Long id) {
        flightProgressStatusService.deleteById(id);
    }
}
