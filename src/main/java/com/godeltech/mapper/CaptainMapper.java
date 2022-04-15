package com.godeltech.mapper;

import com.godeltech.persistence.model.Captain;
import com.godeltech.web.dto.request.CaptainRequestDto;
import com.godeltech.web.dto.response.CaptainResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CaptainMapper {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
    CaptainResponseDto toCaptainResponseDto(Captain captain);

    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "flyingWindSpeed", source = "flyingWindSpeed")
    Captain toCaptain(CaptainRequestDto captainRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Captain captain, CaptainRequestDto captainRequestDto);

    @IterableMapping(elementTargetType = CaptainResponseDto.class)
    List<CaptainResponseDto> toCaptainResponseDtoList(Collection<Captain> captains);
}
