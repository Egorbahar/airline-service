package com.godeltech.service.impl;

import com.godeltech.component.LocalMessageSource;
import com.godeltech.exception.ResourceNotFoundException;
import com.godeltech.persistence.model.Airplane;
import com.godeltech.persistence.repository.AirplaneRepository;
import com.godeltech.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final LocalMessageSource messageSource;

    @Override
    public Airplane findById(final Long id) {
        return airplaneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage("error.record.notExist", new Object[]{})));
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane save(final Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane update(final Airplane airplane) {
        return airplaneRepository.saveAndFlush(airplane);
    }

    @Override
    public void deleteById(final Long id) {
        airplaneRepository.deleteById(id);
    }
}
