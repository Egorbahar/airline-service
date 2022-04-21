package com.godeltech.facade.impl;

import com.godeltech.facade.UserFacade;
import com.godeltech.mapper.UserMapper;
import com.godeltech.persistence.model.User;
import com.godeltech.service.UserService;
import com.godeltech.web.dto.request.UserRequestDto;
import com.godeltech.web.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto findById(final Long id) {
        log.debug("Find user with id:{}", id);
        return userMapper.toUserResponseDto(userService.findById(id));
    }

    @Override
    public List<UserResponseDto> findAll() {
        log.debug("Find all users");
        return userMapper.toUserResponseDtoList(userService.findAll());
    }

    @Override
    public UserResponseDto save(final UserRequestDto userRequestDto) {
        log.debug("Save user");
        return userMapper.toUserResponseDto(userService.save(userMapper.toUser(userRequestDto)));
    }

    @Override
    public UserResponseDto update(final Long id,final UserRequestDto userRequestDto) {
        log.debug("Update user with id:{}", id);
        User user = userService.findById(id);
        userMapper.updateEntity(user, userRequestDto);
        return userMapper.toUserResponseDto(userService.update(user));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete user with id:{}", id);
        userService.deleteById(id);
    }
}
