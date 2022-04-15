package com.godeltech.facade;

import com.godeltech.web.dto.request.EngineerRequestDto;
import com.godeltech.web.dto.response.EngineerResponseDto;

import java.util.List;

public interface EngineerFacade {
    EngineerResponseDto findById(Long id);

    List<EngineerResponseDto> findAll();

    EngineerResponseDto save(EngineerRequestDto engineerRequestDto);

    EngineerResponseDto update(Long id, EngineerRequestDto engineerRequestDto);

    void deleteById(Long id);
}
