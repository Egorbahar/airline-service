package com.godeltech.facade.impl;

import com.godeltech.facade.AirportFacade;
import com.godeltech.mapper.AirportMapper;
import com.godeltech.persistence.model.Airport;
import com.godeltech.service.AirportService;
import com.godeltech.web.dto.request.AirportRequestDto;
import com.godeltech.web.dto.response.AirportResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class AirportFacadeImpl implements AirportFacade {
    private final AirportService airportService;
    private final AirportMapper airportMapper;


    @Override
    public AirportResponseDto findById(final Long id) {
        log.debug("Find airport with id:{}", id);
        return airportMapper.toAirportResponseDto(airportService.findById(id));
    }

    @Override
    public List<AirportResponseDto> findAll() {
        log.debug("Find all airports");
        return airportMapper.toAirportResponseDtoList(airportService.findAll());
    }

    @Override
    public AirportResponseDto save(final AirportRequestDto airportRequestDto) {
        log.debug("Save airport");
        return airportMapper.toAirportResponseDto(airportService.save(airportMapper.toAirport(airportRequestDto)));
    }

    @Override
    public AirportResponseDto update(final Long id, final AirportRequestDto airportRequestDto) {
        log.debug("Update airport with id:{}", id);
        Airport airport = airportService.findById(id);
        airportMapper.updateEntity(airport, airportRequestDto);
        return airportMapper.toAirportResponseDto(airportService.update(airport));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete airport with id:{}", id);
        airportService.deleteById(id);
    }
}
