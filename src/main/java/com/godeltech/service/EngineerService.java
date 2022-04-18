package com.godeltech.service;

import com.godeltech.persistence.model.Engineer;

import java.util.List;

public interface EngineerService {
    Engineer findById(final Long id);

    Engineer save(final Engineer engineer);

    List<Engineer> findAll();

    Engineer update(final Engineer engineer);

    void deleteById(final Long id);
}
