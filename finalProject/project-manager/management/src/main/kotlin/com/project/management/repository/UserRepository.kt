package com.project.management.repository

import com.project.management.model.User
import org.springframework.data.jpa.repository.JpaRepository
<<<<<<< HEAD
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository :JpaRepository<User,Long>{
    fun findUserByUsername (username :String) : Optional<User>
}
=======
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findUserByUsername(username: String): Optional<User>

    @Query("""select u.fullName, u.username
    from User u
    join WorksOn wo on wo.employee.userId=u.userId
    where  wo.project.projectId = :projectId
""")
    fun findAllEmployeesOnProject(@Param("projectId") projectId: Long): List<String>

}
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
