package com.godeltech.service;

import com.godeltech.persistence.model.SecondPilot;

import java.util.List;

public interface SecondPilotService {
    SecondPilot findById(Long id);

    SecondPilot save(SecondPilot secondPilot);

    List<SecondPilot> findAll();

    SecondPilot update(SecondPilot secondPilot);

    void deleteById(Long id);
}
