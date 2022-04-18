package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.FlightProgressStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightProgressStatusRepository extends JpaRepository<FlightProgressStatus,Long> {
}
