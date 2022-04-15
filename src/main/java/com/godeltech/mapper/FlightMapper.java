package com.godeltech.mapper;

import com.godeltech.persistence.model.Flight;
import com.godeltech.web.dto.request.FlightRequestDto;
import com.godeltech.web.dto.response.FlightResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "departureAirportId", source = "departureAirport.id")
    @Mapping(target = "arrivalAirportId", source = "arrivalAirport.id")
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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Flight flight, FlightRequestDto flightRequestDto);

    @IterableMapping(elementTargetType = FlightResponseDto.class)
    List<FlightResponseDto> toFlightResponseDtoList(Collection<Flight> flights);
}
