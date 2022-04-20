package com.godeltech.mapper;

import com.godeltech.persistence.model.User;
import com.godeltech.web.dto.request.UserRequestDto;
import com.godeltech.web.dto.response.UserResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "roleId", source = "role.id")
    UserResponseDto toUserResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role.id", source = "roleId")
    User toUser(UserRequestDto userRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget User user, UserRequestDto userRequestDto);

    @IterableMapping(elementTargetType = UserResponseDto.class)
    List<UserResponseDto> toUserResponseDtoList(Collection<User> users);
}
