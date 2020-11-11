package com.project.management.controller

import com.project.management.controller.requests.UserDto
import com.project.management.model.ResponseMessage
import com.project.management.service.UserRoleService
import com.project.management.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping("/api/account")
@CrossOrigin("*")
class AccountController(val service: UserService, val userRoleService: UserRoleService) {

    //TODO handle erros for DTO
    @PostMapping("/register")
    fun createUser(@RequestBody @Valid userDto: UserDto, request: HttpServletRequest): ResponseEntity<ResponseMessage> {
        service.save(userDto)
        return ResponseEntity(ResponseMessage("User created!"), HttpStatus.CREATED)
    }

    @GetMapping("/login")
    fun logIn(principal: Principal, response: HttpServletResponse, request: HttpServletRequest): Principal = principal

    @GetMapping("/roles")
    fun findAllRoles() = userRoleService.findAllRoles()

}
