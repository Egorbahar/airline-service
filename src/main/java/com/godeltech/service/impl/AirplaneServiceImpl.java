package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.repository.AirplaneRepository;
import com.godeltech.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final LocalMessageSource messageSource;

    @Override
    public Airplane findById(final Long id) {
        log.debug("Find airplane with id:{}", id);
        return airplaneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    public List<Airplane> findAll() {
        log.debug("Find all airplanes");
        return airplaneRepository.findAll();
    }

    @Override
    @Transactional
    public Airplane save(final Airplane airplane) {
        log.debug("Save new airplane");
        return airplaneRepository.save(airplane);
    }

    @Override
    @Transactional
    public Airplane update(final Airplane airplane) {
        log.debug("Update airplane with id:{}", airplane.getId());
        findById(airplane.getId());
        return airplaneRepository.saveAndFlush(airplane);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete airplane with id:{}", id);
        findById(id);
        airplaneRepository.deleteById(id);
    }
}
