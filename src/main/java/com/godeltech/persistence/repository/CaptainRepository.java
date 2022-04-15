package com.godeltech.persistence.repository;

import com.godeltech.persistence.model.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptainRepository extends JpaRepository<Captain, Long> {
}