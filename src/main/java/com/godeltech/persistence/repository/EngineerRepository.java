package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer,Long> {
}
