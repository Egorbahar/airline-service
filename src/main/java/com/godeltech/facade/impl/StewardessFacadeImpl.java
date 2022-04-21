package com.godeltech.facade.impl;

import com.godeltech.facade.StewardessFacade;
import com.godeltech.mapper.StewardessMapper;
import com.godeltech.persistence.model.Stewardess;
import com.godeltech.service.StewardessService;
import com.godeltech.web.dto.request.StewardessRequestDto;
import com.godeltech.web.dto.response.StewardessResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class StewardessFacadeImpl implements StewardessFacade {
    private final StewardessService stewardessService;
    private final StewardessMapper stewardessMapper;

    @Override
    public StewardessResponseDto findById(final Long id) {
        log.debug("Find stewardess with id:{}", id);
        return stewardessMapper.toStewardessResponseDto(stewardessService.findById(id));
    }

    @Override
    public List<StewardessResponseDto> findAll() {
        log.debug("Find all stewardesses");
        return stewardessMapper.toStewardessResponseDtoList(stewardessService.findAll());
    }

    @Override
    public StewardessResponseDto save(final StewardessRequestDto stewardessRequestDto) {
        log.debug("Save stewardess");
        return stewardessMapper.toStewardessResponseDto(stewardessService.save(stewardessMapper.toStewardess(stewardessRequestDto)));
    }

    @Override
    public StewardessResponseDto update(final Long id,final StewardessRequestDto stewardessRequestDto) {
        log.debug("Update stewardess with id:{}", id);
        Stewardess stewardess = stewardessService.findById(id);
        stewardessMapper.updateEntity(stewardess, stewardessRequestDto);
        return stewardessMapper.toStewardessResponseDto(stewardessService.update(stewardess));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete stewardess with id:{}", id);
        stewardessService.deleteById(id);
    }
}
