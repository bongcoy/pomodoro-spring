package com.example.pomodoro.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pomodoro.model.TaskModel;

import jakarta.transaction.Transactional;

@Repository
public interface TaskNativeRepository extends JpaRepository<TaskModel, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO m_task (title, is_completed, created_on) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void create(String title, boolean isCompleted, LocalDateTime createdOn);

    @Query(value = "SELECT * FROM m_task", nativeQuery = true)
    List<TaskModel> findAll();

    @Query(value = "SELECT * FROM m_task WHERE id = ?1", nativeQuery = true)
    Optional<TaskModel> findByIdNative(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE m_task SET title = ?2, is_completed = ?3 , modified_on = ?4 WHERE id = ?1", nativeQuery = true)
    void update(Long id, String title, boolean isCompleted, LocalDateTime modifiedOn);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM m_task WHERE id = ?1", nativeQuery = true)
    void delete(Long id);
}
