package com.tawasol.stratg.lasthouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawasol.stratg.lasthouse.model.Leave;
import com.tawasol.stratg.lasthouse.repository.LeaveRepository;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public Leave applyLeave(Leave leave) {
        // Perform any necessary validations or business logic
        leave.setStatus("Pending"); // Set default status
        return leaveRepository.save(leave);
    }

    public Leave updateLeaveStatus(Long id, String status) {
        Leave leave = leaveRepository.findById(id).orElse(null);
        if (leave != null) {
            leave.setStatus(status);
            return leaveRepository.save(leave);
        }
        return null; // Leave not found
    }

    public Leave updateLeave(Long id, Leave updatedLeave) {
        Leave leave = leaveRepository.findById(id).orElse(null);
        if (leave != null) {
            // Update fields as needed
            leave.setStartDate(updatedLeave.getStartDate());
            leave.setEndDate(updatedLeave.getEndDate());
            leave.setLeaveType(updatedLeave.getLeaveType());
            leave.setReason(updatedLeave.getReason());

            return leaveRepository.save(leave);
        }
        return null; // Leave not found
    }

    public boolean deleteLeave(Long id) {
        if (leaveRepository.existsById(id)) {
            leaveRepository.deleteById(id);
            return true;
        }
        return false; // Leave not found
    }
}
