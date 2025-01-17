package com.example.pomodoro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pomodoro.model.TaskModel;
import com.example.pomodoro.repository.TaskNativeRepository;

@Service
public class TaskNativeService {
    @Autowired
    private TaskNativeRepository taskNativeRepository;

    public TaskModel create(TaskModel task) {
        task.setCreatedOn(LocalDateTime.now());
        taskNativeRepository.create(task.getTitle(), task.getIsCompleted(), task.getCreatedOn());
        return task;
    }

    public List<TaskModel> findAll() {
        return taskNativeRepository.findAll();
    }

    public TaskModel findById(Long id) {
        return taskNativeRepository.findByIdNative(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public TaskModel update(Long id, TaskModel taskDetails) {
        TaskModel task = findById(id);
        task.setTitle(taskDetails.getTitle());
        task.setIsCompleted(taskDetails.getIsCompleted());
        task.setModifiedOn(LocalDateTime.now());
        taskNativeRepository.update(task.getId(), task.getTitle(), task.getIsCompleted(), task.getModifiedOn());
        return task;
    }

    public void delete(Long id) {
        taskNativeRepository.delete(id);
    }
}
