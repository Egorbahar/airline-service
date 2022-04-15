package com.godeltech.facade;

import com.godeltech.web.dto.request.UserRequestDto;
import com.godeltech.web.dto.response.UserResponseDto;

import java.util.List;

public interface UserFacade {
    UserResponseDto findById(Long id);

    List<UserResponseDto> findAll();

    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto update(Long id, UserRequestDto userRequestDto);

    void deleteById(Long id);
}
