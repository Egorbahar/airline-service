package com.godeltech.mapper;

import com.godeltech.mapper.annotaion.UpdateAirplane;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.model.Category;
import com.godeltech.service.CategoryService;
import com.godeltech.web.dto.request.AirplaneRequestDto;
import com.godeltech.web.dto.response.AirplaneResponseDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {
    AirplaneMapper INSTANCE = Mappers.getMapper(AirplaneMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "windSpeed" , source = "windSpeed")
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    AirplaneResponseDto toAirplaneResponseDto(Airplane airplane);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "windSpeed" , source = "windSpeed")
    Airplane toAirplane(AirplaneRequestDto airplaneRequestDto);

    @UpdateAirplane
    default void updateEntity(Airplane airplane, AirplaneRequestDto airplaneRequestDto, Category category) {
        airplane.setName(airplaneRequestDto.getName());
        airplane.setWindSpeed(airplaneRequestDto.getWindSpeed());
        airplane.setCategory(category);
    }
    @IterableMapping(elementTargetType = AirplaneResponseDto.class)
    List<AirplaneResponseDto> toAirplaneResponseDtoList(Collection<Airplane> airplanes);
}
