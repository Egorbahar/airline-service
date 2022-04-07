package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}