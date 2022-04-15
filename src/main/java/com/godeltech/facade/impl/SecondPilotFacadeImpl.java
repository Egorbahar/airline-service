package com.godeltech.facade.impl;

import com.godeltech.facade.SecondPilotFacade;
import com.godeltech.mapper.SecondPilotMapper;
import com.godeltech.persistence.model.SecondPilot;
import com.godeltech.service.SecondPilotService;
import com.godeltech.web.dto.request.SecondPilotRequestDto;
import com.godeltech.web.dto.response.SecondPilotResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SecondPilotFacadeImpl implements SecondPilotFacade {
    private final SecondPilotService secondPilotService;
    private final SecondPilotMapper secondPilotMapper;

    @Override
    public SecondPilotResponseDto findById(Long id) {
        return secondPilotMapper.toSecondPilotResponseDto(secondPilotService.findById(id));
    }

    @Override
    public List<SecondPilotResponseDto> findAll() {
        return secondPilotMapper.toSecondPilotResponseDtoList(secondPilotService.findAll());
    }

    @Override
    public SecondPilotResponseDto save(SecondPilotRequestDto secondPilotRequestDto) {
        return secondPilotMapper.toSecondPilotResponseDto(secondPilotService.save(secondPilotMapper.toSecondPilot(secondPilotRequestDto)));
    }

    @Override
    public SecondPilotResponseDto update(Long id, SecondPilotRequestDto secondPilotRequestDto) {
        SecondPilot secondPilot = secondPilotService.findById(id);
        secondPilotMapper.updateEntity(secondPilot, secondPilotRequestDto);
        return secondPilotMapper.toSecondPilotResponseDto(secondPilotService.update(secondPilot));
    }

    @Override
    public void deleteById(Long id) {
        secondPilotService.deleteById(id);
    }
}
