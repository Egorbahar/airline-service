package com.godeltech.mapper;

import com.godeltech.persistence.model.User;
import com.godeltech.web.dto.request.UserRequestDto;
import com.godeltech.web.dto.response.UserResponseDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
    UserResponseDto toUserResponseDto(User user);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "flyingWindSpeed", source = "flyingWindSpeed")
    User toUser(UserRequestDto userRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget User user, UserRequestDto userRequestDto);

    @IterableMapping(elementTargetType = UserResponseDto.class)
    List<UserResponseDto> toUserResponseDtoList(Collection<User> users);
}
