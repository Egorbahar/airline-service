package com.godeltech.service.impl;

import com.godeltech.persistence.model.Engineer;
import com.godeltech.persistence.repository.EngineerRepository;
import com.godeltech.service.EngineerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineerServiceImpl implements EngineerService {
    private final EngineerRepository engineerRepository;

    @Override
    public Engineer findById(Long id) {
        return engineerRepository.findById(id).orElseThrow();
    }

    @Override
    public Engineer save(Engineer engineer) {
        return engineerRepository.save(engineer);
    }

    @Override
    public List<Engineer> findAll() {
        return engineerRepository.findAll();
    }

    @Override
    public Engineer update(Engineer engineer) {
        return engineerRepository.saveAndFlush(engineer);
    }

    @Override
    public void deleteById(Long id) {
        engineerRepository.deleteById(id);
    }
}
