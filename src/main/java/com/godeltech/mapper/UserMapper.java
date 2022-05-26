package com.godeltech.mapper;

import com.godeltech.mapper.annotaion.UpdateAirplane;
import com.godeltech.mapper.annotaion.UpdateUser;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.model.Category;
import com.godeltech.persistence.model.Role;
import com.godeltech.persistence.model.User;
import com.godeltech.web.dto.request.AirplaneRequestDto;
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
    @Mapping(target = "roleName", source = "role.name")
    UserResponseDto toUserResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role.id", source = "roleId")
    User toUser(UserRequestDto userRequestDto);

    @UpdateUser
    default void updateEntity(final User user,final UserRequestDto userRequestDto,final Role role) {
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(role);
    }

    @IterableMapping(elementTargetType = UserResponseDto.class)
    List<UserResponseDto> toUserResponseDtoList(Collection<User> users);
}
