package com.project.management.controller.requests

import org.jetbrains.annotations.NotNull

data class WorksOnDto(
        @NotNull
        val userId: Long,
        @NotNull
        val projectId: Long
)
