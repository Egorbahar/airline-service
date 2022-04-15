package com.godeltech.facade;

import com.godeltech.web.dto.request.SecondPilotRequestDto;
import com.godeltech.web.dto.response.SecondPilotResponseDto;

import java.util.List;

public interface SecondPilotFacade {
    SecondPilotResponseDto findById(Long id);

    List<SecondPilotResponseDto> findAll();

    SecondPilotResponseDto save(SecondPilotRequestDto secondPilotRequestDto);

    SecondPilotResponseDto update(Long id, SecondPilotRequestDto secondPilotRequestDto);

    void deleteById(Long id);
}
