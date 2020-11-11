package com.project.management.service

import com.project.management.configuration.PasswordEncoderConfiguration
<<<<<<< HEAD
import com.project.management.dto.UserDto
=======
import com.project.management.controller.requests.UserDto
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
import com.project.management.model.User
import com.project.management.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
<<<<<<< HEAD

@Service
class UserService(val repository:UserRepository,val encoder:PasswordEncoderConfiguration):UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =repository.findUserByUsername(username).orElseThrow { Exception("there is no user with ${username}") }

    fun save(userDto : UserDto): User = repository.save(User(username = userDto.username,password =encoder.passwordEncoder().encode(userDto.password),fullName = userDto.fullName ))

    fun find(id:Long): User = repository.findById(id).orElseThrow { Exception("there is no user with such Id") }
    //TODO implement update ... change password for example
}
=======
import javax.transaction.Transactional


@Service
class UserService(val repository: UserRepository, val encoder: PasswordEncoderConfiguration, val
userRoleService: UserRoleService) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails = repository.findUserByUsername(username).orElseThrow { Exception("there is no user with ${username}") }


    fun save(userDto: UserDto): User {

        val role = userRoleService.findById(userDto.role)
                .orElseThrow { RuntimeException("No role found") }

        return repository.save(User(username = userDto.username,
                password = encoder.passwordEncoder().encode(userDto.password),
                fullName = userDto.fullName, role = role))
    }

    fun findById(id: Long): User = repository.findById(id).orElseThrow { Exception("there is no user with such Id") }
    //TODO implement update ... change password for example

    @Transactional
    fun findAllEmployesOnProject(projectId: Long): List<String>
            = repository.findAllEmployeesOnProject(projectId)
}


>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
