package com.example.pomodoro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pomodoro.model.TaskModel;

@Repository
public interface TaskNativeRepository extends JpaRepository<TaskModel, Long> {
    @Query(value = "INSERT INTO m_task (title, is_complete) VALUES (?1, ?2)", nativeQuery = true)
    TaskModel create(String title, boolean isComplete);

    @Query(value = "SELECT * FROM m_task", nativeQuery = true)
    List<TaskModel> findAll();

    @Query(value = "SELECT * FROM m_task WHERE id = ?1", nativeQuery = true)
    TaskModel findByIdNative(Long id);

    @Query(value = "UPDATE m_task SET title = ?2, is_complete = ?3 WHERE id = ?1", nativeQuery = true)
    TaskModel update(Long id, String title, boolean isComplete);

    @Query(value = "DELETE FROM m_task WHERE id = ?1", nativeQuery = true)
    void delete(Long id);
}
