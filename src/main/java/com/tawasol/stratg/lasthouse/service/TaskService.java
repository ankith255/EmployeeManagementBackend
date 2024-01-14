package com.tawasol.stratg.lasthouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawasol.stratg.lasthouse.model.Task;
import com.tawasol.stratg.lasthouse.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksForEmployee(Long employeeId) {
        return taskRepository.findByEmployeeId(employeeId);
    }

    public Task addTask(Task task) {
        // Perform any necessary validations or business logic
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            // Update fields as needed
            task.setTaskName(updatedTask.getTaskName());
            task.setStartTime(updatedTask.getStartTime());
            task.setEndTime(updatedTask.getEndTime());
            task.setDescription(updatedTask.getDescription());

            return taskRepository.save(task);
        }
        return null; // Task not found
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false; // Task not found
    }

    
}
