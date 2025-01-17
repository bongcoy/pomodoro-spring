package com.example.pomodoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pomodoro.model.TaskModel;
import com.example.pomodoro.service.TaskNativeService;

@RestController
@RequestMapping("/api/native/task")
public class TaskNativeController {
    @Autowired
    private TaskNativeService taskNativeService;

    @PostMapping
    public ResponseEntity<TaskModel> create(@RequestBody TaskModel todo) {
        return ResponseEntity.ok(taskNativeService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> findAll() {
        return ResponseEntity.ok(taskNativeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taskNativeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> update(@PathVariable Long id, @RequestBody TaskModel todoDetails) {
        return ResponseEntity.ok(taskNativeService.update(id, todoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskNativeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
