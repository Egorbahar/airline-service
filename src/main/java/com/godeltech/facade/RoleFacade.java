package com.godeltech.facade;

import com.godeltech.web.dto.request.RoleRequestDto;
import com.godeltech.web.dto.response.RoleResponseDto;
import com.godeltech.web.dto.response.UserResponseDto;

import java.util.List;

public interface RoleFacade {
    RoleResponseDto findById(Long id);

    List<RoleResponseDto> findAll();

    RoleResponseDto save(RoleRequestDto roleRequestDto);

    void deleteById(Long id);

    RoleResponseDto update(Long id, RoleRequestDto roleRequestDto);
}
