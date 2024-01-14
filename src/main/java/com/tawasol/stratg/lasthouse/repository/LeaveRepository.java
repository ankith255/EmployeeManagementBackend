package com.tawasol.stratg.lasthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawasol.stratg.lasthouse.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}