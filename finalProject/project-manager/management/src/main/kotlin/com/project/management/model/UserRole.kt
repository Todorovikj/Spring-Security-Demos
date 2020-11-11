package com.project.management.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
import javax.persistence.*


@Entity
data class UserRole(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "role_id")
        val roleId: Long = 0,

        @NotNull
        val roleName: String,

        @OneToMany
        @JoinColumn()
        @JsonIgnore
        val user: List<User>
)
