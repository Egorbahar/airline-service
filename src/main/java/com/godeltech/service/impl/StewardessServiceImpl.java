package com.godeltech.service.impl;

import com.godeltech.persistence.model.Stewardess;
import com.godeltech.persistence.repository.StewardessRepository;
import com.godeltech.service.StewardessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StewardessServiceImpl implements StewardessService {
    private final StewardessRepository stewardessRepository;

    @Override
    public Stewardess findById(final Long id) {
        return stewardessRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Stewardess save(final Stewardess stewardess) {
        return stewardessRepository.save(stewardess);
    }

    @Override
    public List<Stewardess> findAll() {
        return stewardessRepository.findAll();
    }

    @Override
    @Transactional
    public Stewardess update(final Stewardess stewardess) {
        return stewardessRepository.saveAndFlush(stewardess);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        stewardessRepository.deleteById(id);
    }
}
