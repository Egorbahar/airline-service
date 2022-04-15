package com.godeltech.service;

import com.godeltech.persistence.model.Airport;

import java.util.List;

public interface AirportService {
    Airport findById(Long id);

    List<Airport> findAll();

    Airport save(Airport toAirport);

    Airport update(Airport airport);

    void deleteById(Long id);
}
