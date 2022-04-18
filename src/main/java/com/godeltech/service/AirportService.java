package com.godeltech.service;

import com.godeltech.persistence.model.Airport;

import java.util.List;

public interface AirportService {
    Airport findById(final Long id);

    List<Airport> findAll();

    Airport save(final Airport toAirport);

    Airport update(final Airport airport);

    void deleteById(final Long id);
}
