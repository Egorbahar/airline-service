package com.godeltech.service.impl;

import com.godeltech.persistence.model.Flight;
import com.godeltech.persistence.repository.FlightRepository;
import com.godeltech.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public Flight findById(final Long id) {
        return flightRepository.findById(id).orElseThrow();
    }

    @Override
    public Flight save(final Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight update(final Flight flight) {
        return flightRepository.saveAndFlush(flight);
    }

    @Override
    public void deleteById(final Long id) {
        flightRepository.deleteById(id);
    }
}
