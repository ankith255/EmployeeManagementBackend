package com.tawasol.stratg.lasthouse.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tawasol.stratg.lasthouse.model.Attendance;
import com.tawasol.stratg.lasthouse.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Get attendance for a specific employee
    @GetMapping("/{employeeId}")
    public ResponseEntity<List<Attendance>> getAttendanceForEmployee(@PathVariable Long employeeId) {
        List<Attendance> attendance = attendanceService.getAttendanceForEmployee(employeeId);
        return ResponseEntity.ok(attendance);
    }

    // Mark attendance
    @PostMapping
    public ResponseEntity<Attendance> markAttendance(@RequestBody Attendance attendance) {
        Attendance markedAttendance = attendanceService.markAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(markedAttendance);
    }

    // Get attendance between dates for a specific employee
    @GetMapping("/{employeeId}/between")
    public ResponseEntity<List<Attendance>> getAttendanceBetweenDates(
            @PathVariable Long employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Attendance> attendance = attendanceService.getAttendanceBetweenDates(employeeId, startDate, endDate);
        return ResponseEntity.ok(attendance);
    }

    // Get late attendances for a specific employee
    @GetMapping("/{employeeId}/late")
    public ResponseEntity<List<Attendance>> getLateAttendances(@PathVariable Long employeeId) {
        List<Attendance> lateAttendances = attendanceService.getLateAttendances(employeeId);
        return ResponseEntity.ok(lateAttendances);
    }

    // Get absent dates for a specific employee between dates
    @GetMapping("/{employeeId}/absent")
    public ResponseEntity<List<Attendance>> getAbsentDates(
            @PathVariable Long employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Attendance> absentDates = attendanceService.getAbsentDates(employeeId, startDate, endDate);
        return ResponseEntity.ok(absentDates);
    }

    // Add other attendance-related endpoints...
}
