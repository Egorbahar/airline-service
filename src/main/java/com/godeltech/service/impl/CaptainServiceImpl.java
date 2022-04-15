package com.godeltech.service.impl;

import com.godeltech.persistence.model.Captain;
import com.godeltech.persistence.repository.CaptainRepository;
import com.godeltech.service.CaptainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaptainServiceImpl implements CaptainService {
    private final CaptainRepository captainRepository;

    @Override
    public Captain findById(Long id) {
        return captainRepository.findById(id).orElseThrow();
    }

    @Override
    public Captain save(Captain captain) {
        return captainRepository.save(captain);
    }

    @Override
    public List<Captain> findAll() {
        return captainRepository.findAll();
    }

    @Override
    public Captain update(Captain captain) {
        return captainRepository.saveAndFlush(captain);
    }

    @Override
    public void deleteById(Long id) {
        captainRepository.deleteById(id);
    }
}
