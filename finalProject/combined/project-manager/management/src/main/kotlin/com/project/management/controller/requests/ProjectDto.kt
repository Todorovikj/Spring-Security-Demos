package com.project.management.controller.requests

import java.time.LocalDate

class ProjectDto(
        val projectName: String,
        val startDate: LocalDate,
        val estimatedEndDate: LocalDate
)
