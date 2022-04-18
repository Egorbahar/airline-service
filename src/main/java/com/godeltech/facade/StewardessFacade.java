package com.godeltech.facade;

import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;

import java.util.List;

public interface StewardessFacade {
    StewardessResponseDto findById(final Long id);

    List<StewardessResponseDto> findAll();

    StewardessResponseDto save(final StewardessRequestDto stewardessRequestDto);

    StewardessResponseDto update(final Long id, final StewardessRequestDto stewardessRequestDto);

    void deleteById(final Long id);
}
