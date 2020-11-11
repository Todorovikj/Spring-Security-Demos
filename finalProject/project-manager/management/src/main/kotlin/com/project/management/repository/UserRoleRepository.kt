package com.project.management.repository

import com.project.management.model.UserRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRoleRepository : JpaRepository<UserRole, Long> {

    fun findByRoleName(roleName: String): Optional<UserRole>



}
