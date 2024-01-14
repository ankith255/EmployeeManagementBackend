package com.tawasol.stratg.lasthouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tawasol.stratg.lasthouse.model.Holiday;
import com.tawasol.stratg.lasthouse.service.HolidayService;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    // Get all holidays
    @GetMapping
    public ResponseEntity<List<Holiday>> getAllHolidays() {
        List<Holiday> holidays = holidayService.getAllHolidays();
        return ResponseEntity.ok(holidays);
    }

    // Add a new holiday
    @PostMapping
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday) {
        Holiday addedHoliday = holidayService.addHoliday(holiday);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedHoliday);
    }

    // Update holiday details
    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
        Holiday updatedHoliday = holidayService.updateHoliday(id, holiday);
        if (updatedHoliday != null) {
            return ResponseEntity.ok(updatedHoliday);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete holiday by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable Long id) {
        boolean deleted = holidayService.deleteHoliday(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
