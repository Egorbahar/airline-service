package com.godeltech.mapper;

import com.godeltech.mapper.annotaion.UpdateAirplane;
import com.godeltech.mapper.annotaion.UpdateFlight;
import com.godeltech.persistence.model.*;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "departureAirportCode", source = "departureAirport.code")
    @Mapping(target = "arrivalAirportCode", source = "arrivalAirport.code")
    @Mapping(target = "departureAirportId", source = "departureAirport.id")
    @Mapping(target = "arrivalAirportId", source = "arrivalAirport.id")
    @Mapping(target = "planeName", source = "plane.name")
    @Mapping(target = "captainName", source = "captain.name")
    @Mapping(target = "secondPilotName", source = "secondPilot.name")
    @Mapping(target = "engineerName", source = "engineer.name")
    @Mapping(target = "stewardessName", source = "stewardess.name")
    @Mapping(target = "flightProgressStatusName", source = "flightProgressStatus.name")
    @Mapping(target = "flightStartStatusName", source = "flightStartStatus.name")
    @Mapping(target = "planeId", source = "plane.id")
    @Mapping(target = "captainId", source = "captain.id")
    @Mapping(target = "secondPilotId", source = "secondPilot.id")
    @Mapping(target = "engineerId", source = "engineer.id")
    @Mapping(target = "stewardessId", source = "stewardess.id")
    @Mapping(target = "flightProgressStatusId", source = "flightProgressStatus.id")
    @Mapping(target = "flightStartStatusId", source = "flightStartStatus.id")
    FlightResponseDto toFlightResponseDto(Flight flight);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departureAirport.id", source = "departureAirportId")
    @Mapping(target = "arrivalAirport.id", source = "arrivalAirportId")
    @Mapping(target = "plane.id", source = "planeId")
    @Mapping(target = "captain.id", source = "captainId")
    @Mapping(target = "secondPilot.id", source = "secondPilotId")
    @Mapping(target = "engineer.id", source = "engineerId")
    @Mapping(target = "stewardess.id", source = "stewardessId")
    @Mapping(target = "flightProgressStatus.id", source = "flightProgressStatusId")
    @Mapping(target = "flightStartStatus.id", source = "flightStartStatusId")
    Flight toFlight(FlightRequestDto flightRequestDto);

    @UpdateFlight
    default void updateEntity(final Flight flight,
                              final Airport departureAirport,
                              final Airport arrivalAirport,
                              final Airplane airplane,
                              final Captain captain,
                              final SecondPilot secondPilot,
                              final Stewardess stewardess,
                              final Engineer engineer,
                              final FlightStartStatus flightStartStatus,
                              final FlightProgressStatus flightProgressStatus) {
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setPlane(airplane);
        flight.setCaptain(captain);
        flight.setSecondPilot(secondPilot);
        flight.setStewardess(stewardess);
        flight.setEngineer(engineer);
        flight.setFlightProgressStatus(flightProgressStatus);
        flight.setFlightStartStatus(flightStartStatus);
    }
    @IterableMapping(elementTargetType = FlightResponseDto.class)
    List<FlightResponseDto> toFlightResponseDtoList(Collection<Flight> flights);
}
