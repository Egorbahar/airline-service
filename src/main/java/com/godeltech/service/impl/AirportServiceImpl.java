package com.godeltech.service.impl;

import com.godeltech.persistence.model.Airport;
import com.godeltech.persistence.repository.AirportRepository;
import com.godeltech.service.AirportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Override
    public Airport findById(final Long id) {
        log.debug("Find airport with id:{}", id);
        return airportRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Airport> findAll() {
        log.debug("Find all airports");
        return airportRepository.findAll();
    }

    @Override
    @Transactional
    public Airport save(final Airport airport) {
        log.debug("Save new airport");
        return airportRepository.save(airport);
    }

    @Override
    @Transactional
    public Airport update(final Airport airport) {
        log.debug("Update airport with id:{}", airport.getId());
        return airportRepository.saveAndFlush(airport);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete airport with id:{}", id);
        airportRepository.deleteById(id);
    }
}
