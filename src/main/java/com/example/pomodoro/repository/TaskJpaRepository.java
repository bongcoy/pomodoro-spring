package com.example.pomodoro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pomodoro.model.TaskModel;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskModel, Long> {
    
}
