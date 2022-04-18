package com.godeltech.facade;

import com.godeltech.web.dto.request.SecondPilotRequestDto;
import com.godeltech.web.dto.response.SecondPilotResponseDto;

import java.util.List;

public interface SecondPilotFacade {
    SecondPilotResponseDto findById(final Long id);

    List<SecondPilotResponseDto> findAll();

    SecondPilotResponseDto save(final SecondPilotRequestDto secondPilotRequestDto);

    SecondPilotResponseDto update(final Long id, final SecondPilotRequestDto secondPilotRequestDto);

    void deleteById(final Long id);
}
