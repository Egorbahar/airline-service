package com.godeltech.service.impl;

import com.godeltech.persistence.model.Stewardess;
import com.godeltech.persistence.repository.StewardessRepository;
import com.godeltech.service.StewardessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StewardessServiceImpl implements StewardessService {
    private final StewardessRepository stewardessRepository;

    @Override
    public Stewardess findById(Long id) {
        return stewardessRepository.findById(id).orElseThrow();
    }

    @Override
    public Stewardess save(Stewardess stewardess) {
        return stewardessRepository.save(stewardess);
    }

    @Override
    public List<Stewardess> findAll() {
        return stewardessRepository.findAll();
    }

    @Override
    public Stewardess update(Stewardess stewardess) {
        return stewardessRepository.saveAndFlush(stewardess);
    }

    @Override
    public void deleteById(Long id) {
        stewardessRepository.deleteById(id);
    }
}
