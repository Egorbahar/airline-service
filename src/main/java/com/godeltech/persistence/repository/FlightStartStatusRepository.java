package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.FlightStartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightStartStatusRepository extends JpaRepository<FlightStartStatus,Long> {
}
