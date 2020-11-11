package com.project.management.controller.requests

import org.jetbrains.annotations.NotNull
import java.time.LocalDate

class TaskDto(

        @NotNull
        val taskName: String,

        @NotNull
        val description: String,

        @NotNull
        val startDate: LocalDate,


        val estimatedEndDate: LocalDate,

        @NotNull
        val userId: Long,

        @NotNull
        val projectId: Long

)
