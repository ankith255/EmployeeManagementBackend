package com.tawasol.stratg.lasthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawasol.stratg.lasthouse.model.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}