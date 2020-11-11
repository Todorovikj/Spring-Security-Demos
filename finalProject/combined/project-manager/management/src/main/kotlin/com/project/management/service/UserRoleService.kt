package com.project.management.service

import com.project.management.model.UserRole
import com.project.management.repository.UserRoleRepository
import org.springframework.stereotype.Service

@Service
class UserRoleService(val repository: UserRoleRepository) {


    fun findByName(name: String) = repository.findByRoleName(name)

    fun findById(id: Long) = repository.findById(id);

    fun findAllRoles(): List<UserRole> = repository.findAll()
}
