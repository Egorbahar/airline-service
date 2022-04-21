package com.godeltech.facade.impl;

import com.godeltech.facade.CaptainFacade;
import com.godeltech.mapper.CaptainMapper;
import com.godeltech.persistence.model.Captain;
import com.godeltech.service.CaptainService;
import com.godeltech.web.dto.request.CaptainRequestDto;
import com.godeltech.web.dto.response.CaptainResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CaptainFacadeImpl implements CaptainFacade {

    private final CaptainService captainService;
    private final CaptainMapper captainMapper;

    @Override
    public CaptainResponseDto findById(final Long id) {
        log.debug("Find captain with id:{}", id);
        return captainMapper.toCaptainResponseDto(captainService.findById(id));
    }

    @Override
    public List<CaptainResponseDto> findAll() {
        log.debug("Find all captains");
        return captainMapper.toCaptainResponseDtoList(captainService.findAll());
    }

    @Override
    public CaptainResponseDto save(final CaptainRequestDto captainRequestDto) {
        log.debug("Save captain");
        return captainMapper.toCaptainResponseDto(captainService.save(captainMapper.toCaptain(captainRequestDto)));
    }

    @Override
    public CaptainResponseDto update(final Long id,final  CaptainRequestDto captainRequestDto) {
        log.debug("Update captain with id:{}", id);
        Captain captain = captainService.findById(id);
        captainMapper.updateEntity(captain, captainRequestDto);
        return captainMapper.toCaptainResponseDto(captainService.update(captain));
    }

    @Override
    public void deleteById(final Long id) {
        log.debug("Delete captain with id:{}", id);
        captainService.deleteById(id);
    }
}
