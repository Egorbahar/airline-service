package com.godeltech.service.impl;

import com.godeltech.persistence.model.FlightStartStatus;
import com.godeltech.persistence.repository.FlightStartStatusRepository;
import com.godeltech.service.FlightStartStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightStartStatusServiceImpl implements FlightStartStatusService {
    private final FlightStartStatusRepository flightStartStatusRepository;

    @Override
    public FlightStartStatus findById(final Long id) {
        return flightStartStatusRepository.findById(id).orElseThrow();
    }

    @Override
    public FlightStartStatus save(final FlightStartStatus flightStartStatus) {
        return flightStartStatusRepository.save(flightStartStatus);
    }

    @Override
    public List<FlightStartStatus> findAll() {
        return flightStartStatusRepository.findAll();
    }

    @Override
    public FlightStartStatus update(final FlightStartStatus flightStartStatus) {
        return flightStartStatusRepository.saveAndFlush(flightStartStatus);
    }

    @Override
    public void deleteById(final Long id) {
        flightStartStatusRepository.deleteById(id);
    }
}
