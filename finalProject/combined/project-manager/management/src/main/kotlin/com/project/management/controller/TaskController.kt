package com.project.management.controller

import com.project.management.controller.requests.TaskDto
import com.project.management.model.Task
import com.project.management.service.TaskService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/tasks")
class TaskController(val service: TaskService) {

    @GetMapping()
    fun findAllTasks() = service.findAllTasks()

    @GetMapping("/{id}")
    fun findTaskById(@PathVariable("id") id: Long) = service.findById(id)

    @GetMapping("/active")
    fun findAllActiveTasks() = service.findActiveTasks()

    @PostMapping()
    fun createTask(@RequestBody @Valid taskDto: TaskDto): Task =
            service.createTasks(
                    taskName = taskDto.taskName,
                    startDate = taskDto.startDate,
                    estimatedEndDate = taskDto.estimatedEndDate,
                    description = taskDto.description,
                    userId = taskDto.userId,
                    projectId = taskDto.projectId)


    @DeleteMapping("/{id}")
    fun deleteTaskById(@PathVariable("id") id: Long) = service.deleteById(id)

    @GetMapping("/project/{projectId}")
    fun findAllByProject(@PathVariable("projectId") projectId: Long) = service.findAllTasksByProject(projectId)


    @GetMapping("/employee/{userId}")
    fun findAllByEmployee(@PathVariable("userId") userId: Long) =
            service.findAllTaskByEmployee(userId)

}
