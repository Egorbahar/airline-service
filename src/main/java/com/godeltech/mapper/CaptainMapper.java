package com.godeltech.mapper;

import com.godeltech.persistence.model.Captain;
import com.godeltech.web.dto.request.CaptainRequestDto;
import com.godeltech.web.dto.response.CaptainResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CaptainMapper {
    CaptainResponseDto toCaptainResponseDto(Captain captain);

    @Mapping(target = "id", ignore = true)
    Captain toCaptain(CaptainRequestDto captainRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Captain captain, CaptainRequestDto captainRequestDto);

    @IterableMapping(elementTargetType = CaptainResponseDto.class)
    List<CaptainResponseDto> toCaptainResponseDtoList(Collection<Captain> captains);
}
