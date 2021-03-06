package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.SecondPilot;
import com.godeltech.persistence.repository.SecondPilotRepository;
import com.godeltech.service.SecondPilotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.pqc.jcajce.provider.LMS;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class SecondPilotServiceImpl implements SecondPilotService {
    private final SecondPilotRepository secondPilotRepository;
    private final LocalMessageSource messageSource;

    @Override
    public SecondPilot findById(final Long id) {
        log.debug("Find second pilot with id:{}", id);
        return secondPilotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    @Transactional
    public SecondPilot save(final SecondPilot secondPilot) {
        log.debug("Save new second pilot");
        return secondPilotRepository.save(secondPilot);
    }

    @Override
    public List<SecondPilot> findAll() {
        log.debug("Find all second pilots");
        return secondPilotRepository.findAll();
    }

    @Override
    @Transactional
    public SecondPilot update(final SecondPilot secondPilot) {
        log.debug("Update second pilot with id:{}", secondPilot.getId());
        findById(secondPilot.getId());
        return secondPilotRepository.saveAndFlush(secondPilot);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete second pilot with id:{}", id);
        findById(id);
        secondPilotRepository.deleteById(id);
    }
}
