package com.godeltech.facade.impl;

import com.godeltech.facade.EngineerFacade;
import com.godeltech.mapper.EngineerMapper;
import com.godeltech.persistence.model.Engineer;
import com.godeltech.service.EngineerService;
import com.godeltech.web.dto.request.EngineerRequestDto;
import com.godeltech.web.dto.response.EngineerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EngineerFacadeImpl implements EngineerFacade {
    private final EngineerService engineerService;
    private final EngineerMapper engineerMapper;

    @Override
    public EngineerResponseDto findById(final Long id) {
        return engineerMapper.toEngineerResponseDto(engineerService.findById(id));
    }

    @Override
    public List<EngineerResponseDto> findAll() {
        return engineerMapper.toEngineerResponseDtoList(engineerService.findAll());
    }

    @Override
    public EngineerResponseDto save(final EngineerRequestDto engineerRequestDto) {
        return engineerMapper.toEngineerResponseDto(engineerService.save(engineerMapper.toEngineer(engineerRequestDto)));
    }

    @Override
    public EngineerResponseDto update(final Long id, final EngineerRequestDto engineerRequestDto) {
        Engineer engineer = engineerService.findById(id);
        engineerMapper.updateEntity(engineer, engineerRequestDto);
        return engineerMapper.toEngineerResponseDto(engineerService.update(engineer));
    }

    @Override
    public void deleteById(final Long id) {
        engineerService.deleteById(id);
    }
}
