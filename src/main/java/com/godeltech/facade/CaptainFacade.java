package com.godeltech.facade;

import com.godeltech.web.dto.request.CaptainRequestDto;
import com.godeltech.web.dto.response.CaptainResponseDto;

import java.util.List;

public interface CaptainFacade {
    CaptainResponseDto findById(Long id);

    List<CaptainResponseDto> findAll();

    CaptainResponseDto save(CaptainRequestDto captainRequestDto);

    CaptainResponseDto update(Long id, CaptainRequestDto captainRequestDto);

    void deleteById(Long id);
}
