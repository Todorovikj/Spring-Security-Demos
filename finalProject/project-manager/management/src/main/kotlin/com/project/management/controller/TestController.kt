package com.project.management.controller

import com.project.management.model.User
import com.project.management.service.UserService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:4200")
class TestController(val service:UserService){
    @GetMapping("/api/test/{userId}")
    fun testche(@PathVariable("userId") userId:Long): User {
        return service.find(userId)
    }
}