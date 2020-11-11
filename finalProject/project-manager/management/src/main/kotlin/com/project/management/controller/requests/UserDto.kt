package com.project.management.controller.requests

import com.project.management.model.UserRole
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class UserDto(
        @get: Size(min = 3, max = 50)
        @get:Email
        val username: String,
        @get:Size(min = 6, max = 100)
        val password: String,
        @get:Size(min = 4, max = 50)
        val fullName: String,
        @get:NotNull
        val role: Long

)
