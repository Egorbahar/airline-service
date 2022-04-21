package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.Stewardess;
import com.godeltech.persistence.repository.StewardessRepository;
import com.godeltech.service.StewardessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class StewardessServiceImpl implements StewardessService {
    private final StewardessRepository stewardessRepository;
    private final LocalMessageSource messageSource;

    @Override
    public Stewardess findById(final Long id) {
        log.debug("Find stewardess with id:{}", id);
        return stewardessRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    @Transactional
    public Stewardess save(final Stewardess stewardess) {
        log.debug("Save new stewardess");
        return stewardessRepository.save(stewardess);
    }

    @Override
    public List<Stewardess> findAll() {
        log.debug("Find all stewardesses");
        return stewardessRepository.findAll();
    }

    @Override
    @Transactional
    public Stewardess update(final Stewardess stewardess) {
        log.debug("Update stewardess with id:{}", stewardess.getId());
        findById(stewardess.getId());
        return stewardessRepository.saveAndFlush(stewardess);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete stewardess with id:{}", id);
        findById(id);
        stewardessRepository.deleteById(id);
    }
}
