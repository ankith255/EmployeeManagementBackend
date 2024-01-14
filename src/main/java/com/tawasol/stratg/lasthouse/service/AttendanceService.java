package com.tawasol.stratg.lasthouse.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawasol.stratg.lasthouse.model.Attendance;
import com.tawasol.stratg.lasthouse.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceForEmployee(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    public Attendance markAttendance(Attendance attendance) {
        // Perform any necessary validations or business logic
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceBetweenDates(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return attendanceRepository.findByEmployeeIdAndAttendanceDateBetween(employeeId, startDate, endDate);
    }

    public List<Attendance> getLateAttendances(Long employeeId) {
        // Implement logic to retrieve late attendances for a specific employee
        // This is just an example, you may need to customize it based on your business rules
        return attendanceRepository.findLateAttendancesByEmployeeId(employeeId);
    }

    public List<Attendance> getAbsentDates(Long employeeId, LocalDate startDate, LocalDate endDate) {
        // Implement logic to retrieve absent dates for a specific employee
        // This is just an example, you may need to customize it based on your business rules
        return attendanceRepository.findAbsentDatesByEmployeeIdAndAttendanceDateBetween(employeeId, startDate, endDate);
    }

    // Add other attendance-related business logic as needed
}
