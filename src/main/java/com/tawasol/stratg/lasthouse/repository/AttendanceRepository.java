package com.tawasol.stratg.lasthouse.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tawasol.stratg.lasthouse.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployeeId(Long employeeId);

    List<Attendance> findByEmployeeIdAndAttendanceDateBetween(
            Long employeeId, LocalDate startDate, LocalDate endDate);

    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :employeeId AND a.status = 'Late'")
    List<Attendance> findLateAttendancesByEmployeeId(@Param("employeeId") Long employeeId);

    @Query("SELECT a FROM Attendance a " +
           "WHERE a.employee.id = :employeeId " +
           "AND a.attendanceDate BETWEEN :startDate AND :endDate " +
           "AND a.status = 'Absent'")
    List<Attendance> findAbsentDatesByEmployeeIdAndAttendanceDateBetween(
            @Param("employeeId") Long employeeId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
