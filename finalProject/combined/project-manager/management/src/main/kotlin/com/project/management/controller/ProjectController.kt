package com.project.management.controller

import com.project.management.controller.requests.ProjectDto
import com.project.management.controller.requests.WorksOnDto
import com.project.management.model.Project
import com.project.management.model.User
import com.project.management.service.ProjectService
import com.project.management.service.UserService
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/projects")
class ProjectController(val service: ProjectService, val userService: UserService) {

    @GetMapping("/{id}")
    fun findProjectById(@PathVariable("id") id: Long) = service.findProjectById(id)

    @GetMapping()
    fun findAllProjects(): List<Project> = service.findAllProjects()

    @DeleteMapping("/{id}")
    fun deleteProjectById(@PathVariable id: Long) = service.deleteProjectById(id)

    @PostMapping()
    fun createProject(@RequestBody @Valid projectDto: ProjectDto,
                      authentication: Authentication): Project {
        val user: User = userService.loadUserByUsername(authentication.name) as User
        return service.createProject(projectDto.projectName
                , projectDto.startDate, projectDto.estimatedEndDate, user = user)
    }


    @GetMapping("/liveProjects")
    fun findCurrentProjects() = service.currentProjects()

//    @GetMapping("/employees/{id}")
//    fun findEmployeesOnProject(@PathVariable("id") id: Long) = service.findEmployeesOnProject(id)

    @GetMapping("/my")
    fun findProjectsByManager(authentication: Authentication): List<Project> {
        val user: User = userService.loadUserByUsername(authentication.name) as User
        return service.findAllProjectsByManager(user)
    }

    @PostMapping("/addEmployee")
    fun addEmployeeToProject(@RequestBody @Valid worksOnDto: WorksOnDto) {
        this.service.addEmployeeToProject(worksOnDto.userId, worksOnDto.projectId)
    }

    @GetMapping("/employeesOnProject/{projectId}")
    fun findAllEmployeesOnProject(@PathVariable("projectId") projectId: Long): List<User> = userService.findAllEmployesOnProject(projectId)


}
