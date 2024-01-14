package com.tawasol.stratg.lasthouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawasol.stratg.lasthouse.model.Holiday;
import com.tawasol.stratg.lasthouse.repository.HolidayRepository;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Holiday addHoliday(Holiday holiday) {
        // Perform any necessary validations or business logic
        return holidayRepository.save(holiday);
    }

    public Holiday updateHoliday(Long id, Holiday updatedHoliday) {
        Holiday holiday = holidayRepository.findById(id).orElse(null);
        if (holiday != null) {
            // Update fields as needed
            holiday.setHolidayDate(updatedHoliday.getHolidayDate());
            holiday.setDescription(updatedHoliday.getDescription());

            return holidayRepository.save(holiday);
        }
        return null; // Holiday not found
    }

    public boolean deleteHoliday(Long id) {
        if (holidayRepository.existsById(id)) {
            holidayRepository.deleteById(id);
            return true;
        }
        return false; // Holiday not found
    }

}
