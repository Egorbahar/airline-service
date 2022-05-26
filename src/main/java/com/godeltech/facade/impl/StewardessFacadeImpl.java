package com.godeltech.facade.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.AssignmentException;
import com.godeltech.facade.StewardessFacade;
import com.godeltech.mapper.StewardessMapper;
import com.godeltech.persistence.model.Stewardess;
import com.godeltech.service.FlightService;
import com.godeltech.service.StewardessService;
import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class StewardessFacadeImpl implements StewardessFacade {
    private final FlightService flightService;
    private final StewardessService stewardessService;
    private final StewardessMapper stewardessMapper;

    private final LocalMessageSource messageSource;

    @Override
    public StewardessResponseDto findById(final Long id) {
        log.debug("Find stewardess with id:{}", id);
        return stewardessMapper.toStewardessResponseDto(stewardessService.findById(id));
    }

    @Override
    public List<StewardessResponseDto> findAll() {
        log.debug("Find all stewardesses");
        return stewardessMapper.toStewardessResponseDtoList(stewardessService.findAll());
    }

    @Override
    public StewardessResponseDto save(final StewardessRequestDto stewardessRequestDto) {
        log.debug("Save stewardess");
        return stewardessMapper.toStewardessResponseDto(stewardessService.save(stewardessMapper.toStewardess(stewardessRequestDto)));
    }

    @Override
    public StewardessResponseDto update(final Long id, final StewardessRequestDto stewardessRequestDto) {
        log.debug("Update stewardess with id:{}", id);
        final Stewardess stewardess = stewardessService.findById(id);
        stewardessMapper.updateEntity(stewardess, stewardessRequestDto);
        return stewardessMapper.toStewardessResponseDto(stewardessService.update(stewardess));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete stewardess with id:{}", id);
        final boolean isAssignedToFlight = flightService.findAll().stream()
                                                            .map(flight -> flight.getStewardess().getId())
                                                            .collect(Collectors.toList())
                                                            .contains(id);
        if (isAssignedToFlight) {
            throw new AssignmentException(messageSource.getMessage("error.record.isAssignment", new Object[]{}));
        } else {
            stewardessService.deleteById(id);
        }
    }
}
