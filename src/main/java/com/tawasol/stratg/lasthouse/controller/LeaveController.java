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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tawasol.stratg.lasthouse.model.Leave;
import com.tawasol.stratg.lasthouse.service.LeaveService;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	// Get all leaves
	@GetMapping
	public ResponseEntity<List<Leave>> getAllLeaves() {
		List<Leave> leaves = leaveService.getAllLeaves();
		return ResponseEntity.ok(leaves);
	}

	// Get leave by ID
	@GetMapping("/{id}")
	public ResponseEntity<Leave> getLeaveById(@PathVariable Long id) {
		Leave leave = leaveService.getLeaveById(id);
		if (leave != null) {
			return ResponseEntity.ok(leave);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Apply for leave
	@PostMapping
	public ResponseEntity<Leave> applyLeave(@RequestBody Leave leave) {
		Leave appliedLeave = leaveService.applyLeave(leave);
		return ResponseEntity.status(HttpStatus.CREATED).body(appliedLeave);
	}

	// Update leave status (approve/reject)
	@PutMapping("/{id}/status")
	public ResponseEntity<Leave> updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
		Leave updatedLeave = leaveService.updateLeaveStatus(id, status);
		if (updatedLeave != null) {
			return ResponseEntity.ok(updatedLeave);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Update leave details
	@PutMapping("/{id}")
	public ResponseEntity<Leave> updateLeave(@PathVariable Long id, @RequestBody Leave leave) {
		Leave updatedLeave = leaveService.updateLeave(id, leave);
		if (updatedLeave != null) {
			return ResponseEntity.ok(updatedLeave);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete leave by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
		boolean deleted = leaveService.deleteLeave(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
