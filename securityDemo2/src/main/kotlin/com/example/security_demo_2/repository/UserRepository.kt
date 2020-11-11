package com.example.security_demo_2.repository

import com.example.security_demo_2.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): Optional<User>;
    fun existsByUsername(username: String): Boolean;
    fun existsByEmail(email: String): Boolean;
}