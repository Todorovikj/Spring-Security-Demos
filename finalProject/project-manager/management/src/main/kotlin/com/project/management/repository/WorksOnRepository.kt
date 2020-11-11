package com.project.management.repository

import com.project.management.model.WorksOn
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorksOnRepository:JpaRepository<WorksOn,Long> {
}
