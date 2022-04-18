package com.godeltech.service;

import com.godeltech.persistence.model.SecondPilot;

import java.util.List;

public interface SecondPilotService {
    SecondPilot findById(final Long id);

    SecondPilot save(final SecondPilot secondPilot);

    List<SecondPilot> findAll();

    SecondPilot update(final SecondPilot secondPilot);

    void deleteById(final Long id);
}
