package com.project.management.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Project(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val projectId: Long = 0,

        @NotNull
        @Column(name = "project_name", columnDefinition = "TEXT")
        val projectName: String,


        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @NotNull
        val startDate: LocalDate,


        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        val estimatedEndDate: LocalDate,
        //TODO DISCUSS IF ONE MANAGER MANAGES MULTIPLE PROJECTS


//        @ManyToOne
//        @JoinColumn(name = "managerId")
//        @JsonIgnore
//        val manager: Manager? = null,
//
//
//        @ManyToOne
//        @JoinColumn(name = "employeeId", insertable = false, updatable = false)
//        @JsonIgnore
//        val employee: Employee? = null


        @ManyToOne
        @JoinColumn(name = "userId")
        @NotNull
        val manager: User




)


