package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.FlightStartStatus;
import com.godeltech.persistence.repository.FlightStartStatusRepository;
import com.godeltech.service.FlightStartStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class FlightStartStatusServiceImpl implements FlightStartStatusService {
    private final FlightStartStatusRepository flightStartStatusRepository;
    private final LocalMessageSource messageSource;

    @Override
    public FlightStartStatus findById(final Long id) {
        log.debug("Find start status with id:{}", id);
        return flightStartStatusRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    @Transactional
    public FlightStartStatus save(final FlightStartStatus flightStartStatus) {
        log.debug("Save start status");
        return flightStartStatusRepository.save(flightStartStatus);
    }

    @Override
    public List<FlightStartStatus> findAll() {
        log.debug("Find all start statuses");
        return flightStartStatusRepository.findAll();
    }

    @Override
    @Transactional
    public FlightStartStatus update(final FlightStartStatus flightStartStatus) {
        log.debug("Update start status with id:{}", flightStartStatus.getId());
        findById(flightStartStatus.getId());
        return flightStartStatusRepository.saveAndFlush(flightStartStatus);
    }

    @Override
    @Transactional
    public void deleteById(final Long id) {
        log.debug("Delete start status with id:{}", id);
        findById(id);
        flightStartStatusRepository.deleteById(id);
    }
}
