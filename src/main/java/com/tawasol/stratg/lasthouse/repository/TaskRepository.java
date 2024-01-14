package com.tawasol.stratg.lasthouse.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tawasol.stratg.lasthouse.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByEmployeeId(Long employeeId);

}
