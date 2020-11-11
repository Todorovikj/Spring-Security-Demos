package com.project.management.service

import com.project.management.model.Project
import com.project.management.model.User
import com.project.management.model.WorksOn
import com.project.management.repository.ProjectRepository
import com.project.management.repository.WorksOnRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class ProjectService(val repository: ProjectRepository,
                     val userService: UserService,
                     val worksOnRepository: WorksOnRepository) {

    fun findProjectById(id: Long): Project = repository.findById(id)
            .orElseThrow { Exception("") }

    fun findAllProjects(): List<Project> = repository.findAll()

    @Transactional
    fun deleteProjectById(id: Long) = repository.deleteProjectByProjectId(id)

    fun createProject(projectName: String, startDate: LocalDate, estimatedEndDate: LocalDate, user: User) {


        val project = Project(startDate = startDate,
                estimatedEndDate = estimatedEndDate,
                projectName = projectName, manager = user)
        repository.save(project)
    }

    fun currentProjects(): List<Project> = repository.findCurrentProjects()

    fun findAllProjectsByManager(user: User): List<Project> {
        return repository.findAllByManager(user)
    }

    fun addEmployeeToProject(userId: Long, projectId: Long) {
        val user = userService.findById(userId)
        val project = this.findProjectById(projectId)
        worksOnRepository.save(WorksOn(employee = user, project = project))
    }
}
