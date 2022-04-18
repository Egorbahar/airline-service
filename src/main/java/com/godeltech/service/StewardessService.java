package com.godeltech.service;

import com.godeltech.persistence.model.Stewardess;

import java.util.List;

public interface StewardessService {
    Stewardess findById(final Long id);

    Stewardess save(final Stewardess stewardess);

    List<Stewardess> findAll();

    Stewardess update(final Stewardess stewardess);

    void deleteById(final Long id);
}
