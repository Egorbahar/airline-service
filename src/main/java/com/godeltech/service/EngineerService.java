package com.godeltech.service;

import com.godeltech.persistence.model.Engineer;

import java.util.List;

public interface EngineerService {
    Engineer findById(Long id);

    Engineer save(Engineer engineer);

    List<Engineer> findAll();

    Engineer update(Engineer engineer);

    void deleteById(Long id);
}
