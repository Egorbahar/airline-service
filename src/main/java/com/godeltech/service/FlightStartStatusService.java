package com.godeltech.service;

import com.godeltech.persistence.model.FlightStartStatus;

import java.util.List;

public interface FlightStartStatusService {
    FlightStartStatus findById(Long id);

    FlightStartStatus save(FlightStartStatus flightStartStatus);

    List<FlightStartStatus> findAll();

    FlightStartStatus update(FlightStartStatus flightStartStatus);

    void deleteById(Long id);
}
