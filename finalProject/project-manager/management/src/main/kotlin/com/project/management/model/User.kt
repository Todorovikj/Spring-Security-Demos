package com.project.management.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
<<<<<<< HEAD
=======
import javax.validation.constraints.NotNull
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
import javax.validation.constraints.Size

@Entity
@Table(name = "users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["username"], name = "username_unique_constraint")
])
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
        val id: Long = 0,
=======
        val userId: Long = 0,
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
        @NotBlank
        @Email
        @Size(min = 4, max = 50)
        private val username: String,
        @NotBlank
<<<<<<< HEAD
        @Size(min=3,max=50)
=======
        @Size(min = 3, max = 50)
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
        val fullName: String,
        @NotBlank
        @Size(min = 6, max = 100)
        private val password: String,
        //TODO make roles table?
<<<<<<< HEAD
        @NotBlank
        val role: String = "USER",
        // TODO implement verification by email
        private val isEnabled: Boolean = true
) : UserDetails {
    override fun getAuthorities(): Collection<out GrantedAuthority> =
            arrayListOf<String>(role).map{SimpleGrantedAuthority(it)}
=======

//        @OneToMany
//        @JsonIgnore
//        private val project: List<Project> = arrayListOf(),


        @NotNull
        @ManyToOne
        @JoinColumn(name = "roleId")
        val role: UserRole,
        // TODO implement verification by email
        private val isEnabled: Boolean = true
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> =
            arrayListOf(role.roleName)
                    .map { SimpleGrantedAuthority(it) }
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc

    override fun isEnabled(): Boolean = isEnabled

    override fun getUsername(): String = username

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}
