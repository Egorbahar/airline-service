package com.godeltech.mapper;

import com.godeltech.persistence.model.Stewardess;
import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StewardessMapper {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
    StewardessResponseDto toStewardessResponseDto(Stewardess stewardess);

    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "flyingWindSpeed", source = "flyingWindSpeed")
    Stewardess toStewardess(StewardessRequestDto stewardessRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Stewardess stewardess, StewardessRequestDto stewardessRequestDto);

    @IterableMapping(elementTargetType = StewardessResponseDto.class)
    List<StewardessResponseDto> toStewardessResponseDtoList(Collection<Stewardess> stewardesses);
}
