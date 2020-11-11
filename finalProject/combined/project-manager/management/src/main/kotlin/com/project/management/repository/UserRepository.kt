package com.project.management.repository

import com.project.management.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findUserByUsername(username: String): Optional<User>

    @Query("""select u
    from User u
    join WorksOn wo on wo.employee.userId=u.userId
    where  wo.project.projectId = :projectId
""")
    fun findAllEmployeesOnProject(@Param("projectId") projectId: Long): List<User>
    @Query("""
        select u from User u where u.role.roleName='EMPLOYEE'
    """)

    fun findAllEmployees():List<User>
}
