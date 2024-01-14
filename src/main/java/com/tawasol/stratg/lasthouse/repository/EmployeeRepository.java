package com.tawasol.stratg.lasthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawasol.stratg.lasthouse.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
