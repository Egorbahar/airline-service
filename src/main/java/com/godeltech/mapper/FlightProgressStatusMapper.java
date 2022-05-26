package com.godeltech.mapper;

import com.godeltech.persistence.model.FlightProgressStatus;
import com.godeltech.web.dto.request.FlightProgressStatusRequestDto;
import com.godeltech.web.dto.response.FlightProgressStatusResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightProgressStatusMapper {
    @Mapping(target = "id", source = "id")
    FlightProgressStatusResponseDto toFlightProgressStatusResponseDto(FlightProgressStatus flightProgressStatus);

    @Mapping(target = "id", ignore = true)
    FlightProgressStatus toFlightProgressStatus(FlightProgressStatusRequestDto flightProgressStatusRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget FlightProgressStatus flightProgressStatus, FlightProgressStatusRequestDto flightProgressStatusRequestDto);

    @IterableMapping(elementTargetType = FlightProgressStatusResponseDto.class)
    List<FlightProgressStatusResponseDto> toFlightProgressStatusResponseDtoList(Collection<FlightProgressStatus> flightProgressStatuses);
}
