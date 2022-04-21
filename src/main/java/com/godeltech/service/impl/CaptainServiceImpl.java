package com.godeltech.service.impl;

import com.godeltech.persistence.model.Captain;
import com.godeltech.persistence.repository.CaptainRepository;
import com.godeltech.service.CaptainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CaptainServiceImpl implements CaptainService {
    private final CaptainRepository captainRepository;

    @Override
    public Captain findById(final Long id) {
        log.debug("Find captain with id:{}", id);
        return captainRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Captain save(final Captain captain) {
        log.debug("Save new captain");
        return captainRepository.save(captain);
    }

    @Override
    public List<Captain> findAll() {
        log.debug("Find all captains");
        return captainRepository.findAll();
    }

    @Override
    @Transactional
    public Captain update(final Captain captain) {
        log.debug("Update captain with id:{}", captain.getId());
        return captainRepository.saveAndFlush(captain);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete captain with id:{}", id);
        captainRepository.deleteById(id);
    }
}
