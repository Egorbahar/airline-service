package com.godeltech.facade.impl;

import com.godeltech.facade.FlightProgressStatusFacade;
import com.godeltech.mapper.FlightProgressStatusMapper;
import com.godeltech.persistence.model.FlightProgressStatus;
import com.godeltech.service.FlightProgressStatusService;
import com.godeltech.web.dto.request.FlightProgressStatusRequestDto;
import com.godeltech.web.dto.response.FlightProgressStatusResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class FlightProgressStatusFacadeImpl implements FlightProgressStatusFacade {
    private final FlightProgressStatusService flightProgressStatusService;
    private final FlightProgressStatusMapper flightProgressStatusMapper;

    @Override
    public FlightProgressStatusResponseDto findById(final Long id) {
        log.debug("Find progress status with id:{}", id);
        return flightProgressStatusMapper.toFlightProgressStatusResponseDto(flightProgressStatusService.findById(id));
    }

    @Override
    public List<FlightProgressStatusResponseDto> findAll() {
        log.debug("Find all progress statuses with");
        return flightProgressStatusMapper.toFlightProgressStatusResponseDtoList(flightProgressStatusService.findAll());
    }

    @Override
    public FlightProgressStatusResponseDto save(final FlightProgressStatusRequestDto flightProgressStatusRequestDto) {
        log.debug("Save progress status");
        return flightProgressStatusMapper.toFlightProgressStatusResponseDto(flightProgressStatusService.save(flightProgressStatusMapper.toFlightProgressStatus(flightProgressStatusRequestDto)));
    }

    @Override
    public FlightProgressStatusResponseDto update(final Long id, final FlightProgressStatusRequestDto flightProgressStatusRequestDto) {
        log.debug("Update progress status with id:{}", id);
        final FlightProgressStatus flightProgressStatus = flightProgressStatusService.findById(id);
        flightProgressStatusMapper.updateEntity(flightProgressStatus, flightProgressStatusRequestDto);
        return flightProgressStatusMapper.toFlightProgressStatusResponseDto(flightProgressStatusService.update(flightProgressStatus));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete progress status with id:{}", id);
        flightProgressStatusService.deleteById(id);
    }
}
