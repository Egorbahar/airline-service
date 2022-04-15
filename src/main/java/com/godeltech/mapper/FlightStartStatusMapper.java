package com.godeltech.mapper;

import com.godeltech.persistence.model.FlightStartStatus;
import com.godeltech.web.dto.request.FlightStartStatusRequestDto;
import com.godeltech.web.dto.response.FlightStartStatusResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightStartStatusMapper {
    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
    FlightStartStatusResponseDto toFlightStartStatusResponseDto(FlightStartStatus flightStartStatus);

    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "flyingWindSpeed", source = "flyingWindSpeed")
    FlightStartStatus toFlightStartStatus(FlightStartStatusRequestDto flightStartStatusRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget FlightStartStatus flightStartStatus, FlightStartStatusRequestDto flightStartStatusRequestDto);

    @IterableMapping(elementTargetType = FlightStartStatusResponseDto.class)
    List<FlightStartStatusResponseDto> toFlightStartStatusResponseDtoList(Collection<FlightStartStatus> flightStartStatuses);
}
