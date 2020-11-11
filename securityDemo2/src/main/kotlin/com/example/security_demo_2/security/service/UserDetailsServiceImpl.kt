package com.example.security_demo_2.security.service

import com.example.security_demo_2.model.User
import com.example.security_demo_2.repository.UserRepository

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(val userRepository: UserRepository) : UserDetailsService {
    //TODO make exception handling better, ex. using controller advice
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
                .orElseThrow { Exception("There is no user with username...") }
        return UserPrinciple.build(user)
    }
}