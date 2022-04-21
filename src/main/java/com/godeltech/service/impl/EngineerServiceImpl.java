package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.Engineer;
import com.godeltech.persistence.repository.EngineerRepository;
import com.godeltech.service.EngineerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class EngineerServiceImpl implements EngineerService {
    private final EngineerRepository engineerRepository;
    private final LocalMessageSource messageSource;

    @Override
    public Engineer findById(final Long id) {
        log.debug("Find engineer with id:{}", id);
        return engineerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    @Transactional
    public Engineer save(final Engineer engineer) {
        log.debug("Save new engineer");
        return engineerRepository.save(engineer);
    }

    @Override
    public List<Engineer> findAll() {
        log.debug("Find all engineers");
        return engineerRepository.findAll();
    }

    @Override
    @Transactional
    public Engineer update(final Engineer engineer) {
        log.debug("Find engineer with id:{}", engineer.getId());
        findById(engineer.getId());
        return engineerRepository.saveAndFlush(engineer);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete engineer with id:{}", id);
        findById(id);
        engineerRepository.deleteById(id);
    }
}
