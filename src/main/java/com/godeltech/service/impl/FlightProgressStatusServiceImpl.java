package com.godeltech.service.impl;

import com.godeltech.persistence.model.FlightProgressStatus;
import com.godeltech.persistence.repository.FlightProgressStatusRepository;
import com.godeltech.service.FlightProgressStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FlightProgressStatusServiceImpl implements FlightProgressStatusService {
    private final FlightProgressStatusRepository flightProgressStatusRepository;

    @Override
    public FlightProgressStatus findById(final Long id) {
        return flightProgressStatusRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public FlightProgressStatus save(final FlightProgressStatus flightProgressStatus) {
        return flightProgressStatusRepository.save(flightProgressStatus);
    }

    @Override
    public List<FlightProgressStatus> findAll() {
        return flightProgressStatusRepository.findAll();
    }

    @Override
    @Transactional
    public FlightProgressStatus update(final FlightProgressStatus flightProgressStatus) {
        return flightProgressStatusRepository.saveAndFlush(flightProgressStatus);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        flightProgressStatusRepository.deleteById(id);
    }
}
