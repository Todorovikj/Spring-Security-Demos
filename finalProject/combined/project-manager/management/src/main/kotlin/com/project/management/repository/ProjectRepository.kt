package com.project.management.repository

import com.project.management.model.Project
import com.project.management.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProjectRepository : JpaRepository<Project, Long> {

    @Query("SELECT p from Project p where p.estimatedEndDate > CURRENT_DATE")
    fun findCurrentProjects(): List<Project>

    @Query("SELECT p from Project p where p.estimatedEndDate < CURRENT_DATE")
    fun findFinishedProjects(): List<Project>


    fun deleteProjectByProjectId(id: Long)

    fun findAllByManager(user: User): List<Project>


}
