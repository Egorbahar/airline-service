package com.godeltech.facade.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.AssignmentException;
import com.godeltech.facade.EngineerFacade;
import com.godeltech.mapper.EngineerMapper;
import com.godeltech.persistence.model.Engineer;
import com.godeltech.service.EngineerService;
import com.godeltech.service.FlightService;
import com.godeltech.web.dto.request.EngineerRequestDto;
import com.godeltech.web.dto.response.EngineerResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class EngineerFacadeImpl implements EngineerFacade {
    private final FlightService flightService;
    private final LocalMessageSource messageSource;
    private final EngineerService engineerService;
    private final EngineerMapper engineerMapper;

    @Override
    public EngineerResponseDto findById(final Long id) {
        log.debug("Find engineer with id:{}", id);
        return engineerMapper.toEngineerResponseDto(engineerService.findById(id));
    }

    @Override
    public List<EngineerResponseDto> findAll() {
        log.debug("Find all engineers");
        return engineerMapper.toEngineerResponseDtoList(engineerService.findAll());
    }

    @Override
    public EngineerResponseDto save(final EngineerRequestDto engineerRequestDto) {
        log.debug("Save engineer");
        return engineerMapper.toEngineerResponseDto(engineerService.save(engineerMapper.toEngineer(engineerRequestDto)));
    }

    @Override
    public EngineerResponseDto update(final Long id, final EngineerRequestDto engineerRequestDto) {
        log.debug("Update engineer with id:{}", id);
        final Engineer engineer = engineerService.findById(id);
        engineerMapper.updateEntity(engineer, engineerRequestDto);
        return engineerMapper.toEngineerResponseDto(engineerService.update(engineer));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete engineer with id:{}", id);
        final boolean isAssignedToFlight = flightService.findAll().stream()
                .map(flight -> flight.getCaptain().getId())
                .collect(Collectors.toList())
                .contains(id);
        if (isAssignedToFlight) {
            throw new AssignmentException(messageSource.getMessage("error.record.isAssignment", new Object[]{}));
        } else {
            engineerService.deleteById(id);
        }

    }
}
