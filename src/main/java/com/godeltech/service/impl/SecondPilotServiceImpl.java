package com.godeltech.service.impl;

import com.godeltech.persistence.model.SecondPilot;
import com.godeltech.persistence.repository.SecondPilotRepository;
import com.godeltech.service.SecondPilotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecondPilotServiceImpl implements SecondPilotService {
    private final SecondPilotRepository secondPilotRepository;

    @Override
    public SecondPilot findById(final Long id) {
        return secondPilotRepository.findById(id).orElseThrow();
    }

    @Override
    public SecondPilot save(final SecondPilot secondPilot) {
        return secondPilotRepository.save(secondPilot);
    }

    @Override
    public List<SecondPilot> findAll() {
        return secondPilotRepository.findAll();
    }

    @Override
    public SecondPilot update(final SecondPilot secondPilot) {
        return secondPilotRepository.saveAndFlush(secondPilot);
    }

    @Override
    public void deleteById(final Long id) {
        secondPilotRepository.deleteById(id);
    }
}
