package com.godeltech.service.impl;

import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.repository.AirplaneRepository;
import com.godeltech.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    @Override
    public Airplane findById(Long id) {
        return airplaneRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane update(Airplane airplane) {
        return airplaneRepository.saveAndFlush(airplane);
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }
}
