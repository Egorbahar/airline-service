package com.godeltech.service.impl;

import com.godeltech.persistence.model.FlightStartStatus;
import com.godeltech.persistence.repository.FlightStartStatusRepository;
import com.godeltech.service.FlightStartStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FlightStartStatusServiceImpl implements FlightStartStatusService {
    private final FlightStartStatusRepository flightStartStatusRepository;

    @Override
    public FlightStartStatus findById(final Long id) {
        return flightStartStatusRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public FlightStartStatus save(final FlightStartStatus flightStartStatus) {
        return flightStartStatusRepository.save(flightStartStatus);
    }

    @Override
    public List<FlightStartStatus> findAll() {
        return flightStartStatusRepository.findAll();
    }

    @Override
    @Transactional
    public FlightStartStatus update(final FlightStartStatus flightStartStatus) {
        return flightStartStatusRepository.saveAndFlush(flightStartStatus);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        flightStartStatusRepository.deleteById(id);
    }
}
