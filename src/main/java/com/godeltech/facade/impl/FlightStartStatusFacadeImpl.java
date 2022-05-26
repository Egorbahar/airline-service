package com.godeltech.facade.impl;

import com.godeltech.facade.FlightStartStatusFacade;
import com.godeltech.mapper.FlightStartStatusMapper;
import com.godeltech.persistence.model.FlightStartStatus;
import com.godeltech.service.FlightStartStatusService;
import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
@RequiredArgsConstructor
public class FlightStartStatusFacadeImpl implements FlightStartStatusFacade {
    private final FlightStartStatusService flightStartStatusService;
    private final FlightStartStatusMapper flightStartStatusMapper;

    @Override
    public FlightStartStatusResponseDto findById(final Long id) {
        log.debug("Find start status with id:{}", id);
        return flightStartStatusMapper.toFlightStartStatusResponseDto(flightStartStatusService.findById(id));
    }

    @Override
    public List<FlightStartStatusResponseDto> findAll() {
        log.debug("Find all start statuses");
        return flightStartStatusMapper.toFlightStartStatusResponseDtoList(flightStartStatusService.findAll());
    }

    @Override
    public FlightStartStatusResponseDto save(final FlightStartStatusRequestDto flightStartStatusRequestDto) {
        log.debug("Save start status");
        return flightStartStatusMapper.toFlightStartStatusResponseDto(flightStartStatusService.save(flightStartStatusMapper.toFlightStartStatus(flightStartStatusRequestDto)));
    }

    @Override
    public FlightStartStatusResponseDto update(final Long id,final FlightStartStatusRequestDto flightStartStatusRequestDto) {
        log.debug("Update start status with id:{}", id);
        final FlightStartStatus flightStartStatus = flightStartStatusService.findById(id);
        flightStartStatusMapper.updateEntity(flightStartStatus, flightStartStatusRequestDto);
        return flightStartStatusMapper.toFlightStartStatusResponseDto(flightStartStatusService.update(flightStartStatus));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete start status with id:{}", id);
        flightStartStatusService.deleteById(id);
    }
}
