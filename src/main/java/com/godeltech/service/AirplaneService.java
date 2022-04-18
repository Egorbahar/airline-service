package com.godeltech.service;

import com.godeltech.persistence.model.Airplane;

import java.util.List;

public interface AirplaneService {
    Airplane findById(final Long id);

    List<Airplane> findAll();

    Airplane save(final Airplane airplane);

    Airplane update(final Airplane airplane);

    void deleteById(final Long id);
}
