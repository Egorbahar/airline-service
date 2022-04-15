package com.godeltech.facade.impl;

import com.godeltech.facade.AirportFacade;
import com.godeltech.mapper.AirportMapper;
import com.godeltech.persistence.model.Airport;
import com.godeltech.service.AirportService;
import com.godeltech.web.dto.request.AirportRequestDto;
import com.godeltech.web.dto.response.AirportResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AirportFacadeImpl implements AirportFacade {
    private final AirportService airportService;
    private final AirportMapper airportMapper;


    @Override
    public AirportResponseDto findById(Long id) {
        return airportMapper.toAirportResponseDto(airportService.findById(id));
    }

    @Override
    public List<AirportResponseDto> findAll() {
        return airportMapper.toAirportResponseDtoList(airportService.findAll());
    }

    @Override
    public AirportResponseDto save(AirportRequestDto airportRequestDto) {
        return airportMapper.toAirportResponseDto(airportService.save(airportMapper.toAirport(airportRequestDto)));
    }

    @Override
    public AirportResponseDto update(Long id, AirportRequestDto airportRequestDto) {
        Airport airport = airportService.findById(id);
        airportMapper.updateEntity(airport,airportRequestDto);
        return airportMapper.toAirportResponseDto(airportService.update(airport));
    }

    @Override
    public void deleteById(Long id) {
        airportService.deleteById(id);
    }
}
