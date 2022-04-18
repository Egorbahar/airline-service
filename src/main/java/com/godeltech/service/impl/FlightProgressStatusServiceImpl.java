package com.godeltech.service.impl;

import com.godeltech.persistence.model.FlightProgressStatus;
import com.godeltech.persistence.repository.FlightProgressStatusRepository;
import com.godeltech.service.FlightProgressStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightProgressStatusServiceImpl implements FlightProgressStatusService {
    private final FlightProgressStatusRepository flightProgressStatusRepository;

    @Override
    public FlightProgressStatus findById(final Long id) {
        return flightProgressStatusRepository.findById(id).orElseThrow();
    }

    @Override
    public FlightProgressStatus save(final FlightProgressStatus flightProgressStatus) {
        return flightProgressStatusRepository.save(flightProgressStatus);
    }

    @Override
    public List<FlightProgressStatus> findAll() {
        return flightProgressStatusRepository.findAll();
    }

    @Override
    public FlightProgressStatus update(final FlightProgressStatus flightProgressStatus) {
        return flightProgressStatusRepository.saveAndFlush(flightProgressStatus);
    }

    @Override
    public void deleteById(final Long id) {
        flightProgressStatusRepository.deleteById(id);
    }
}
