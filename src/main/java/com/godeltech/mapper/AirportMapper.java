package com.godeltech.mapper;

import com.godeltech.persistence.model.Airport;
import com.godeltech.web.dto.request.AirportRequestDto;
import com.godeltech.web.dto.response.AirportResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "code" , source = "code")
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "visibility", source = "visibility")
    AirportResponseDto toAirportResponseDto(Airport airport);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code" , source = "code")
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "visibility", source = "visibility")
    Airport toAirport(AirportRequestDto airportRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Airport airport, AirportRequestDto airportRequestDto);

    @IterableMapping(elementTargetType = AirportResponseDto.class)
    List<AirportResponseDto> toAirportResponseDtoList(Collection<Airport> airports);
}
