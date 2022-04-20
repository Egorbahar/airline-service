package com.godeltech.service.impl;

import com.godeltech.persistence.model.Flight;
import com.godeltech.persistence.repository.FlightRepository;
import com.godeltech.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public Flight findById(final Long id) {
        return flightRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Flight save(final Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    @Transactional
    public Flight update(final Flight flight) {
        return flightRepository.saveAndFlush(flight);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        flightRepository.deleteById(id);
    }
}
