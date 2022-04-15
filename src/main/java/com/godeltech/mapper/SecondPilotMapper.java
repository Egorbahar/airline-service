package com.godeltech.mapper;

import com.godeltech.persistence.model.SecondPilot;
import com.godeltech.web.dto.request.SecondPilotRequestDto;
import com.godeltech.web.dto.response.SecondPilotResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SecondPilotMapper {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
    SecondPilotResponseDto toSecondPilotResponseDto(SecondPilot secondPilot);

    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "flyingWindSpeed", source = "flyingWindSpeed")
    SecondPilot toSecondPilot(SecondPilotRequestDto secondPilotRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget SecondPilot secondPilot, SecondPilotRequestDto secondPilotRequestDto);

    @IterableMapping(elementTargetType = SecondPilotResponseDto.class)
    List<SecondPilotResponseDto> toSecondPilotResponseDtoList(Collection<SecondPilot> secondPilots);
}
