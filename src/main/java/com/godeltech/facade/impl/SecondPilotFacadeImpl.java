package com.godeltech.facade.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.AssignmentException;
import com.godeltech.facade.SecondPilotFacade;
import com.godeltech.mapper.SecondPilotMapper;
import com.godeltech.persistence.model.SecondPilot;
import com.godeltech.service.FlightService;
import com.godeltech.service.SecondPilotService;
import com.godeltech.web.dto.request.SecondPilotRequestDto;
import com.godeltech.web.dto.response.SecondPilotResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class SecondPilotFacadeImpl implements SecondPilotFacade {
    private final FlightService flightService;
    private final SecondPilotService secondPilotService;
    private final SecondPilotMapper secondPilotMapper;
    private final LocalMessageSource messageSource;

    @Override
    public SecondPilotResponseDto findById(final Long id) {
        log.debug("Find second pilot with id:{}", id);
        return secondPilotMapper.toSecondPilotResponseDto(secondPilotService.findById(id));
    }

    @Override
    public List<SecondPilotResponseDto> findAll() {
        log.debug("Find all second pilots");
        return secondPilotMapper.toSecondPilotResponseDtoList(secondPilotService.findAll());
    }

    @Override
    public SecondPilotResponseDto save(final SecondPilotRequestDto secondPilotRequestDto) {
        log.debug("Save second pilot");
        return secondPilotMapper.toSecondPilotResponseDto(secondPilotService.save(secondPilotMapper.toSecondPilot(secondPilotRequestDto)));
    }

    @Override
    public SecondPilotResponseDto update(final Long id, final SecondPilotRequestDto secondPilotRequestDto) {
        log.debug("Update second pilot with id:{}", id);
        final SecondPilot secondPilot = secondPilotService.findById(id);
        secondPilotMapper.updateEntity(secondPilot, secondPilotRequestDto);
        return secondPilotMapper.toSecondPilotResponseDto(secondPilotService.update(secondPilot));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete second pilot with id:{}", id);
        final boolean isAssignedToFlight = flightService.findAll().stream()
                .map(flight -> flight.getSecondPilot().getId())
                .collect(Collectors.toList())
                .contains(id);
        if (isAssignedToFlight) {
            throw new AssignmentException(messageSource.getMessage("error.record.isAssignment", new Object[]{}));
        } else {
            secondPilotService.deleteById(id);
        }

    }
}
