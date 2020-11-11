package com.example.security_demo_2.model

import org.hibernate.annotations.GeneratorType
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name="users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["username"],name="username_unique_constraint"),
    UniqueConstraint(columnNames = ["email"],name="email_unique_constraint")
])
data class User (
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        val id: Long = 0,
        @NotBlank
        @Size(min=3,max=50)
        val username:String,
        @NotBlank
        @Email
        @Size(min=4,max=50)
        val email:String,
        @NotBlank
        @Size(min=6,max=100)
        val password:String,
        //TODO make roles table?
        @NotBlank
        val role:String,
        // TODO implement verification by email
        val isEnabled:Boolean =true
)