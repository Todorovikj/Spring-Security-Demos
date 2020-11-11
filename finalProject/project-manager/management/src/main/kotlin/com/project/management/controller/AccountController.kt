package com.project.management.controller

<<<<<<< HEAD
import com.project.management.dto.UserDto
import com.project.management.model.ResponseMessage
import com.project.management.model.User
import com.project.management.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.servlet.http.Cookie
=======
import com.project.management.controller.requests.UserDto
import com.project.management.model.ResponseMessage
import com.project.management.service.UserRoleService
import com.project.management.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
<<<<<<< HEAD
@RequestMapping("api/account")
@CrossOrigin("*")
class AccountController(val service: UserService) {

    //TODO handle erros for DTO
    @PostMapping("/register")
    fun createUser(@RequestBody @Valid  userDto: UserDto, request: HttpServletRequest): ResponseEntity<ResponseMessage> {
=======
@RequestMapping("/api/account")
@CrossOrigin("*")
class AccountController(val service: UserService, val userRoleService: UserRoleService) {

    //TODO handle erros for DTO
    @PostMapping("/register")
    fun createUser(@RequestBody @Valid userDto: UserDto, request: HttpServletRequest): ResponseEntity<ResponseMessage> {
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
        service.save(userDto)
        return ResponseEntity(ResponseMessage("User created!"), HttpStatus.CREATED)
    }

    @GetMapping("/login")
<<<<<<< HEAD
    fun logIn(principal: Principal, response: HttpServletResponse,request:HttpServletRequest): Principal = principal

//    @PostMapping("/logout")
//    fun logOut(request : HttpServletRequest){
//        System.out.println("IN LOGOUT");
//        val session=request.getSession()
//        session.invalidate()
//        request.cookies.get(0).value=null
//        System.out.println(request.cookies.get(0));
//    }

}
=======
    fun logIn(principal: Principal, response: HttpServletResponse, request: HttpServletRequest): Principal = principal

    @GetMapping("/roles")
    fun findAllRoles() = userRoleService.findAllRoles()

}
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
