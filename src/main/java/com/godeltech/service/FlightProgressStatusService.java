package com.godeltech.service;

import com.godeltech.persistence.model.FlightProgressStatus;

import java.util.List;

public interface FlightProgressStatusService {
    FlightProgressStatus findById(final Long id);

    FlightProgressStatus save(final FlightProgressStatus flightProgressStatus);

    List<FlightProgressStatus> findAll();

    FlightProgressStatus update(final FlightProgressStatus flightProgressStatus);

    void deleteById(final Long id);
}
