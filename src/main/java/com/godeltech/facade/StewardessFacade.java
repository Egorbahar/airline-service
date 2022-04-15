package com.godeltech.facade;

import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;

import java.util.List;

public interface StewardessFacade {
    StewardessResponseDto findById(Long id);

    List<StewardessResponseDto> findAll();

    StewardessResponseDto save(StewardessRequestDto stewardessRequestDto);

    StewardessResponseDto update(Long id, StewardessRequestDto stewardessRequestDto);

    void deleteById(Long id);
}
