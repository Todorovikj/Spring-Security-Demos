package com.project.management.repository

import com.project.management.model.Project
import com.project.management.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TaskRepository : JpaRepository<Task, Long> {

    @Query("SELECT t from Task t " +
            "where  t.estimatedEndDate > current_date ")
    fun findActiveTasks()

    fun findAllByEmployeeUserId(id: Long): List<Task>

    fun findAllByProjectProjectId(id: Long): List<Task>
}
