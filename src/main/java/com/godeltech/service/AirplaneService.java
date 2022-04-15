package com.godeltech.service;

import com.godeltech.persistence.model.Airplane;

import java.util.List;

public interface AirplaneService {
    Airplane findById(Long id);

    List<Airplane> findAll();

    Airplane save(Airplane airplane);

    Airplane update(Airplane airplane);

    void deleteById(Long id);
}
