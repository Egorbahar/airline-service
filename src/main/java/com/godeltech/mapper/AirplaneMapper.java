package com.godeltech.mapper;

import com.godeltech.persistence.model.Airplane;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "windSpeed" , source = "windSpeed")
    @Mapping(target = "categoryId", source = "category.id")
    AirplaneResponseDto toAirplaneResponseDto(Airplane airplane);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "windSpeed" , source = "windSpeed")
    Airplane toAirplane(AirplaneRequestDto airplaneRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Airplane airplane, AirplaneRequestDto airplaneRequestDto);

    @IterableMapping(elementTargetType = AirplaneResponseDto.class)
    List<AirplaneResponseDto> toAirplaneResponseDtoList(Collection<Airplane> airplanes);
}
