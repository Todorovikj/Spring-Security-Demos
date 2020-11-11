package com.project.management.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Task(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val taskId: Long,

        @Column(name = "task_name", columnDefinition = "TEXT")
        val taskName: String,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @NotNull
        val startDate: LocalDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        val estimatedEndDate: LocalDate,


        @NotNull
        @Column(columnDefinition = "TEXT")
        val description: String,


        @ManyToOne
        @JoinColumn(name = "projectId")
        @JsonIgnore
        val project: Project,


        @ManyToOne
        @JoinColumn(name = "userId")
        @JsonIgnore
        val employee: User
)

