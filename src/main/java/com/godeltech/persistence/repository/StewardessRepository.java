package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.Stewardess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StewardessRepository extends JpaRepository<Stewardess, Long> {
}