package com.godeltech.facade;

import com.godeltech.web.dto.request.EngineerRequestDto;
import com.godeltech.web.dto.response.EngineerResponseDto;

import java.util.List;

public interface EngineerFacade {
    EngineerResponseDto findById(final Long id);

    List<EngineerResponseDto> findAll();

    EngineerResponseDto save(final EngineerRequestDto engineerRequestDto);

    EngineerResponseDto update(final Long id, final EngineerRequestDto engineerRequestDto);

    void deleteById(final Long id);
}
