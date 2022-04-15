package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}