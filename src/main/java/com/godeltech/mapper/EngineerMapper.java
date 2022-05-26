package com.godeltech.mapper;

import com.godeltech.persistence.model.Engineer;
import com.godeltech.web.dto.request.EngineerRequestDto;
import com.godeltech.web.dto.response.EngineerResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EngineerMapper {
    EngineerResponseDto toEngineerResponseDto(Engineer engineer);

    @Mapping(target = "id", ignore = true)
    Engineer toEngineer(EngineerRequestDto engineerRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Engineer engineer, EngineerRequestDto engineerRequestDto);

    @IterableMapping(elementTargetType = EngineerResponseDto.class)
    List<EngineerResponseDto> toEngineerResponseDtoList(Collection<Engineer> engineers);
}
