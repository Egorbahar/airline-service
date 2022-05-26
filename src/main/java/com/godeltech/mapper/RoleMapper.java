package com.godeltech.mapper;

import com.godeltech.persistence.model.Role;
import com.godeltech.web.dto.request.RoleRequestDto;
import com.godeltech.web.dto.response.RoleResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    RoleResponseDto toRoleResponseDto(Role role);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    Role toRole(RoleRequestDto roleRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Role role, RoleRequestDto roleRequestDto);

    @IterableMapping(elementTargetType = RoleResponseDto.class)
    List<RoleResponseDto> toRoleResponseDtoList(Collection<Role> roles);
}
