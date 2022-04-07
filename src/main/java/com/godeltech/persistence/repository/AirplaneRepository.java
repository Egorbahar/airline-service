package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}