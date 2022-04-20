package com.godeltech.service.impl;

import com.godeltech.persistence.model.Captain;
import com.godeltech.persistence.repository.CaptainRepository;
import com.godeltech.service.CaptainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CaptainServiceImpl implements CaptainService {
    private final CaptainRepository captainRepository;

    @Override
    public Captain findById(final Long id) {
        return captainRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Captain save(final Captain captain) {
        return captainRepository.save(captain);
    }

    @Override
    public List<Captain> findAll() {
        return captainRepository.findAll();
    }

    @Override
    @Transactional
    public Captain update(final Captain captain) {
        return captainRepository.saveAndFlush(captain);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        captainRepository.deleteById(id);
    }
}
