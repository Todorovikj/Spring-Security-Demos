package com.project.management.service

import com.project.management.model.Task
import com.project.management.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class TaskService(val repository: TaskRepository, val userService: UserService, val projectService: ProjectService) {

    fun findAllTasks(): List<Task> = repository.findAll()

    fun findById(id: Long) = repository.findById(id)

    fun findActiveTasks() = repository.findActiveTasks()

    fun createTasks(taskName: String, startDate: LocalDate, estimatedEndDate: LocalDate, description: String, userId: Long, projectId: Long): Task {
        val user = userService.findById(userId)
        val project = projectService.findProjectById(projectId)

        val task: Task = Task(0, taskName, startDate = startDate, estimatedEndDate = estimatedEndDate, description = description,
                employee = user, project = project)
                return repository.save(task)

    }

    @Transactional
    fun deleteById(id: Long) = repository.deleteById(id)


    fun findAllTaskByEmployee(userId : Long) = repository.findAllByEmployeeUserId(userId)

    fun findAllTasksByProject(projectId : Long) = repository.findAllByProjectProjectId(projectId)
}
