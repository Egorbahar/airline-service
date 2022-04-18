package com.godeltech.facade;

import com.godeltech.web.dto.request.CaptainRequestDto;
import com.godeltech.web.dto.response.CaptainResponseDto;

import java.util.List;

public interface CaptainFacade {
    CaptainResponseDto findById(final Long id);

    List<CaptainResponseDto> findAll();

    CaptainResponseDto save(final CaptainRequestDto captainRequestDto);

    CaptainResponseDto update(final Long id,final CaptainRequestDto captainRequestDto);

    void deleteById(final Long id);
}
