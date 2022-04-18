package com.godeltech.service;

import com.godeltech.persistence.model.Captain;

import java.util.List;

public interface CaptainService {
    Captain findById(final Long id);

    Captain save(final Captain captain);

    List<Captain> findAll();

    Captain update(final Captain captain);

    void deleteById(final Long id);
}
