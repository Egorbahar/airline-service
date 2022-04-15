package com.godeltech.service;

import com.godeltech.persistence.model.Captain;

import java.util.List;

public interface CaptainService {
    Captain findById(Long id);

    Captain save(Captain captain);

    List<Captain> findAll();

    Captain update(Captain captain);

    void deleteById(Long id);
}
