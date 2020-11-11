package com.project.management.controller

import com.project.management.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(val userService: UserService) {
    @GetMapping("/employees")
    fun findAllEmployees() = userService.findAllEmployees();
}