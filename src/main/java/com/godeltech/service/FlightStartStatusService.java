package com.godeltech.service;

import com.godeltech.persistence.model.FlightStartStatus;

import java.util.List;

public interface FlightStartStatusService {
    FlightStartStatus findById(final Long id);

    FlightStartStatus save(final FlightStartStatus flightStartStatus);

    List<FlightStartStatus> findAll();

    FlightStartStatus update(final FlightStartStatus flightStartStatus);

    void deleteById(final Long id);
}
