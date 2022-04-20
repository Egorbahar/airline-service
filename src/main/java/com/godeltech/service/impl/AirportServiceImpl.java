package com.godeltech.service.impl;

import com.godeltech.persistence.model.Airport;
import com.godeltech.persistence.repository.AirportRepository;
import com.godeltech.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Override
    public Airport findById(final Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    @Transactional
    public Airport save(final Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    @Transactional
    public Airport update(final Airport airport) {
        return airportRepository.saveAndFlush(airport);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        airportRepository.deleteById(id);
    }
}
