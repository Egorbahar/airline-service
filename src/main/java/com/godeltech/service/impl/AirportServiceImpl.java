package com.godeltech.service.impl;

import com.godeltech.persistence.model.Airport;
import com.godeltech.persistence.repository.AirportRepository;
import com.godeltech.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Override
    public Airport findById(Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport update(Airport airport) {
        return airportRepository.saveAndFlush(airport);
    }

    @Override
    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }
}
