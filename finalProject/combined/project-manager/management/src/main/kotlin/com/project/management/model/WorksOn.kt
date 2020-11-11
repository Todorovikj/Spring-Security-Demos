package com.project.management.model

import javax.persistence.*

@Entity
data class WorksOn(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long=0,

        @ManyToOne
        @JoinColumn(name = "userId")
        val employee: User,

        @ManyToOne
        @JoinColumn(name = "projectId")
        val project: Project

)



