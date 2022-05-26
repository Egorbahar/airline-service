package com.godeltech.facade.impl;

import com.godeltech.config.AirlineUrlConstant;
import com.godeltech.exception.StatusException;
import com.godeltech.exception.WeatherConditionsException;
import com.godeltech.facade.FlightFacade;
import com.godeltech.mapper.FlightMapper;
import com.godeltech.persistence.model.*;
import com.godeltech.service.*;
import com.godeltech.web.dto.WeatherDto;
import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@PropertySource("classpath:validationMessages.properties")
@Slf4j
@RequiredArgsConstructor
public class FlightFacadeImpl implements FlightFacade {
    private final FlightService flightService;
    private final AirplaneService airplaneService;
    private final AirportService airportService;
    private final CaptainService captainService;
    private final EngineerService engineerService;
    private final StewardessService stewardessService;
    private final SecondPilotService secondPilotService;
    private final FlightStartStatusService flightStartStatusService;
    private final FlightProgressStatusService flightProgressStatusService;
    private final FlightMapper flightMapper;
    private final RestTemplate restTemplate;
    @Value("${valid.start.status}")
    private String validStartStatus;

    @Override
    public FlightResponseDto findById(final Long id) {
        log.debug("Find flight with id:{}", id);
        return flightMapper.toFlightResponseDto(flightService.findById(id));
    }

    @Override
    public List<FlightResponseDto> findAll() {
        log.debug("Find all flights");
        return flightMapper.toFlightResponseDtoList(flightService.findAll());
    }

    @Override
    public FlightResponseDto save(final FlightRequestDto flightRequestDto) {
        log.debug("Save flight");
        return flightMapper.toFlightResponseDto(flightService.save(flightMapper.toFlight(flightRequestDto)));
    }

    @Override
    public FlightResponseDto update(final Long id, final FlightRequestDto flightRequestDto) {
        log.debug("Update flight with id:{}", id);
        final Flight flight = flightService.findById(id);
        final Airport departureAirport = airportService.findById(flightRequestDto.getDepartureAirportId());
        final Airport arrivalAirport = airportService.findById(flightRequestDto.getArrivalAirportId());
        final Airplane airplane = airplaneService.findById(flightRequestDto.getPlaneId());
        final Captain captain = captainService.findById(flightRequestDto.getCaptainId());
        final SecondPilot secondPilot = secondPilotService.findById(flightRequestDto.getSecondPilotId());
        final Stewardess stewardess = stewardessService.findById(flightRequestDto.getStewardessId());
        final Engineer engineer = engineerService.findById(flightRequestDto.getEngineerId());
        final FlightStartStatus flightStartStatus = flightStartStatusService.findById(flightRequestDto.getFlightStartStatusId());
        final FlightProgressStatus flightProgressStatus = flightProgressStatusService.findById(flightRequestDto.getFlightProgressStatusId());
        if (checkWeatherCondition(flight, flightStartStatus)) {
            flightMapper.updateEntity(flight,
                    departureAirport,
                    arrivalAirport,
                    airplane,
                    captain,
                    secondPilot,
                    stewardess,
                    engineer,
                    flightStartStatus,
                    flightProgressStatus);
        }
        return flightMapper.toFlightResponseDto(flightService.update(flight));
    }

    @Override
    public FlightResponseDto updateFlightStartStatus(final Long flightId, final Long statusId) {
        log.debug("Partial update flight with id:{}", flightId);
        final Flight flight = flightService.findById(flightId);
        final FlightStartStatus flightStartStatus = flightStartStatusService.findById(statusId);
        if (checkWeatherCondition(flight, flightStartStatus)) {
            flight.setFlightStartStatus(flightStartStatusService.findById(statusId));
        }
        return flightMapper.toFlightResponseDto(flightService.update(flight));
    }

    @Override
    public FlightResponseDto updateFlightProgressStatus(final Long flightId, final Long statusId) {
        log.debug("Partial update flight with id:{}", flightId);
        final Flight flight = flightService.findById(flightId);
        if (checkPermissibleStartStatus(flight)) {
            flight.setFlightProgressStatus(flightProgressStatusService.findById(statusId));
        } else throw new StatusException("Start status is invalid for changing progress status");
        return flightMapper.toFlightResponseDto(flightService.update(flight));
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Delete flight with id:{}", id);
        flightService.deleteById(id);
    }

    private boolean checkWeatherCondition(final Flight flight, final FlightStartStatus flightStartStatus) {
        log.debug("Check weather condition");
        final String url = AirlineUrlConstant.WEATHER_SERVICE_URL + flight.getDepartureAirport().getCityName();
        final WeatherDto weatherDto = restTemplate.getForObject(url, WeatherDto.class);
        if (weatherDto != null) {
            if ((flight.getPlane().getWindSpeed() <= weatherDto.getSpeedWind() || weatherDto.getVisibility() <= flight.getDepartureAirport().getVisibility()) && flightStartStatus.getName().equals(validStartStatus)) {
                throw new WeatherConditionsException("Weather conditions dont suit the start of the flight! Status <<Confirmed>> is invalid");
            }
        }
        return true;
    }

    private boolean checkPermissibleStartStatus(final Flight flight) {
        log.debug("Check permission for start status");
        return flight.getFlightStartStatus() != null && flight.getFlightStartStatus().getName().equals(validStartStatus);
    }
}
