package com.godeltech.facade.impl;

import com.godeltech.facade.StewardessFacade;
import com.godeltech.mapper.StewardessMapper;
import com.godeltech.persistence.model.Stewardess;
import com.godeltech.service.StewardessService;
import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StewardessFacadeImpl implements StewardessFacade {
    private final StewardessService stewardessService;
    private final StewardessMapper stewardessMapper;

    @Override
    public StewardessResponseDto findById(Long id) {
        return stewardessMapper.toStewardessResponseDto(stewardessService.findById(id));
    }

    @Override
    public List<StewardessResponseDto> findAll() {
        return stewardessMapper.toStewardessResponseDtoList(stewardessService.findAll());
    }

    @Override
    public StewardessResponseDto save(StewardessRequestDto stewardessRequestDto) {
        return stewardessMapper.toStewardessResponseDto(stewardessService.save(stewardessMapper.toStewardess(stewardessRequestDto)));
    }

    @Override
    public StewardessResponseDto update(Long id, StewardessRequestDto stewardessRequestDto) {
        Stewardess stewardess = stewardessService.findById(id);
        stewardessMapper.updateEntity(stewardess, stewardessRequestDto);
        return stewardessMapper.toStewardessResponseDto(stewardessService.update(stewardess));
    }

    @Override
    public void deleteById(Long id) {
        stewardessService.deleteById(id);
    }
}
