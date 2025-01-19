package com.example.pomodoro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pomodoro.model.TaskModel;
import com.example.pomodoro.repository.TaskJpaRepository;

@Service
public class TaskJpaService {
    @Autowired
    private TaskJpaRepository taskJpaRepository;

    public TaskModel create(TaskModel todo) {
        todo.setCreatedOn(LocalDateTime.now());
        return taskJpaRepository.save(todo);
    }

    public List<TaskModel> findAll() {
        return taskJpaRepository.findAll();
    }

    public TaskModel findById(Long id) {
        return taskJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public TaskModel update(Long id, TaskModel todoDetails) {
        TaskModel todo = findById(id);
        todo.setTitle(todoDetails.getTitle());
        todo.setIsCompleted(todoDetails.getIsCompleted());
        todo.setModifiedOn(LocalDateTime.now());
        return taskJpaRepository.save(todo);
    }

    public void delete(Long id) {
        taskJpaRepository.deleteById(id);
    }
}
