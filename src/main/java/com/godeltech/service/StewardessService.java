package com.godeltech.service;

import com.godeltech.persistence.model.Stewardess;

import java.util.List;

public interface StewardessService {
    Stewardess findById(Long id);

    Stewardess save(Stewardess stewardess);

    List<Stewardess> findAll();

    Stewardess update(Stewardess stewardess);

    void deleteById(Long id);
}
