package com.godeltech.facade.impl;

import com.godeltech.exception.StatusException;
import com.godeltech.exception.WeatherConditionsException;
import com.godeltech.facade.FlightFacade;
import com.godeltech.mapper.FlightMapper;
import com.godeltech.persistence.model.Flight;
import com.godeltech.service.FlightProgressStatusService;
import com.godeltech.service.FlightService;
import com.godeltech.service.FlightStartStatusService;
import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;
import com.godeltech.web.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightFacadeImpl implements FlightFacade {
    private final FlightService flightService;
    private final FlightStartStatusService flightStartStatusService;
    private final FlightProgressStatusService flightProgressStatusService;
    private final FlightMapper flightMapper;
    private final RestTemplate restTemplate;

    @Override
    public FlightResponseDto findById(final Long id) {
        return flightMapper.toFlightResponseDto(flightService.findById(id));
    }

    @Override
    public List<FlightResponseDto> findAll() {
        return flightMapper.toFlightResponseDtoList(flightService.findAll());
    }

    @Override
    public FlightResponseDto save(final FlightRequestDto flightRequestDto) {
        return flightMapper.toFlightResponseDto(flightService.save(flightMapper.toFlight(flightRequestDto)));
    }

    @Override
    public FlightResponseDto update(final Long id, final FlightRequestDto flightRequestDto) {
        Flight flight = flightService.findById(id);
        flightMapper.updateEntity(flight, flightRequestDto);
        return flightMapper.toFlightResponseDto(flightService.update(flight));
    }

    @Override
    public FlightResponseDto updateFlightStartStatus(final Long modelId, final Long statusId) {
        Flight flight = flightService.findById(modelId);
        if (checkWeatherCondition(flight, statusId)) {
            flight.setFlightStartStatus(flightStartStatusService.findById(statusId));
        }
        return flightMapper.toFlightResponseDto(flightService.update(flight));
    }

    @Override
    public FlightResponseDto updateFlightProgressStatus(final Long modelId, final Long statusId) {
        Flight flight = flightService.findById(modelId);
        if (checkPermissibleStartStatus(flight)) {
            flight.setFlightProgressStatus(flightProgressStatusService.findById(statusId));
        } else throw new StatusException("Start status is invalid for changing progress status");
        return flightMapper.toFlightResponseDto(flightService.update(flight));
    }

    @Override
    public void deleteById(Long id) {
        flightService.deleteById(id);
    }

    private boolean checkWeatherCondition(final Flight flight,final Long statusId) {
        String url = "http://WEATHER-SERVICE/api/weather?city=" + flight.getDepartureAirport().getCityName();
        WeatherDto weatherDto = restTemplate.getForObject(url, WeatherDto.class);
        if (weatherDto != null) {
            if ((flight.getPlane().getWindSpeed() <= weatherDto.getSpeedWind() || weatherDto.getVisibility() <= flight.getDepartureAirport().getVisibility()) && statusId == 2) {
                throw new WeatherConditionsException("Weather conditions dont suit the start of the flight! Status <<Confirmed>> is invalid");
            }
        }
        return true;
    }

    private boolean checkPermissibleStartStatus(final Flight flight) {
        if (flight.getFlightStartStatus() == null) {
            return false;
        }
        return flight.getFlightStartStatus().getId() == 2;
    }
}
