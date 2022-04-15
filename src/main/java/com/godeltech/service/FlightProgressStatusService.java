package com.godeltech.service;

import com.godeltech.persistence.model.FlightProgressStatus;

import java.util.List;

public interface FlightProgressStatusService {
    FlightProgressStatus findById(Long id);

    FlightProgressStatus save(FlightProgressStatus flightProgressStatus);

    List<FlightProgressStatus> findAll();

    FlightProgressStatus update(FlightProgressStatus flightProgressStatus);

    void deleteById(Long id);
}
