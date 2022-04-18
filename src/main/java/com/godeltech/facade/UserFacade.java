package com.godeltech.facade;

import com.godeltech.web.dto.request.UserRequestDto;
import com.godeltech.web.dto.response.UserResponseDto;

import java.util.List;

public interface UserFacade {
    UserResponseDto findById(final Long id);

    List<UserResponseDto> findAll();

    UserResponseDto save(final UserRequestDto userRequestDto);

    UserResponseDto update(final Long id, final UserRequestDto userRequestDto);

    void deleteById(final Long id);
}
