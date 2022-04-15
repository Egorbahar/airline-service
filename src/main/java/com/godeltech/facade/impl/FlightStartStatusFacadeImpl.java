package com.godeltech.facade.impl;

import com.godeltech.facade.FlightStartStatusFacade;
import com.godeltech.mapper.FlightStartStatusMapper;
import com.godeltech.persistence.model.FlightStartStatus;
import com.godeltech.service.FlightStartStatusService;
import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class FlightStartStatusFacadeImpl implements FlightStartStatusFacade {
    private final FlightStartStatusService flightStartStatusService;
    private final FlightStartStatusMapper flightStartStatusMapper;

    @Override
    public FlightStartStatusResponseDto findById(Long id) {
        return flightStartStatusMapper.toFlightStartStatusResponseDto(flightStartStatusService.findById(id));
    }

    @Override
    public List<FlightStartStatusResponseDto> findAll() {
        return flightStartStatusMapper.toFlightStartStatusResponseDtoList(flightStartStatusService.findAll());
    }

    @Override
    public FlightStartStatusResponseDto save(FlightStartStatusRequestDto flightStartStatusRequestDto) {
        return flightStartStatusMapper.toFlightStartStatusResponseDto(flightStartStatusService.save(flightStartStatusMapper.toFlightStartStatus(flightStartStatusRequestDto)));
    }

    @Override
    public FlightStartStatusResponseDto update(Long id, FlightStartStatusRequestDto flightStartStatusRequestDto) {
        FlightStartStatus flightStartStatus = flightStartStatusService.findById(id);
        flightStartStatusMapper.updateEntity(flightStartStatus, flightStartStatusRequestDto);
        return flightStartStatusMapper.toFlightStartStatusResponseDto(flightStartStatusService.update(flightStartStatus));
    }

    @Override
    public void deleteById(Long id) {
        flightStartStatusService.deleteById(id);
    }
}
