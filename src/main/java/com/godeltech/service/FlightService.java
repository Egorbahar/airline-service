package com.godeltech.service;

import com.godeltech.persistence.model.Flight;

import java.util.List;

public interface FlightService {
    Flight findById(Long id);

    Flight save(Flight flight);

    List<Flight> findAll();

    Flight update(Flight flight);

    void deleteById(Long id);
}
