package com.godeltech.service.impl;

import com.godeltech.persistence.model.FlightProgressStatus;
import com.godeltech.persistence.repository.FlightProgressStatusRepository;
import com.godeltech.service.FlightProgressStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class FlightProgressStatusServiceImpl implements FlightProgressStatusService {
    private final FlightProgressStatusRepository flightProgressStatusRepository;

    @Override
    public FlightProgressStatus findById(final Long id) {
        log.debug("Find progress status with id:{}", id);
        return flightProgressStatusRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public FlightProgressStatus save(final FlightProgressStatus flightProgressStatus) {
        log.debug("Save new progress status");
        return flightProgressStatusRepository.save(flightProgressStatus);
    }

    @Override
    public List<FlightProgressStatus> findAll() {
        log.debug("Find all progress statuses");
        return flightProgressStatusRepository.findAll();
    }

    @Override
    @Transactional
    public FlightProgressStatus update(final FlightProgressStatus flightProgressStatus) {
        log.debug("Update progress status with id:{}", flightProgressStatus.getId());
        return flightProgressStatusRepository.saveAndFlush(flightProgressStatus);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete progress status with id:{}", id);
        flightProgressStatusRepository.deleteById(id);
    }
}
