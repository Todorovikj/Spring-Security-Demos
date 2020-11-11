package com.example.security_demo_2.security.service

import com.example.security_demo_2.model.User
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserPrinciple(
        val id:Long,
        private val username:String,
        private val email:String,
        @JsonIgnore
        private val password:String,
        private val isEnabled:Boolean,
        private val authorities:  Collection<out GrantedAuthority>
): UserDetails {
    override fun getAuthorities(): Collection<out GrantedAuthority> =authorities

    override fun isEnabled(): Boolean =true;

    override fun getUsername(): String =username

    override fun isCredentialsNonExpired(): Boolean =true

    override fun getPassword(): String =password

    override fun isAccountNonExpired(): Boolean =true

    override fun isAccountNonLocked(): Boolean =true
    companion object Factory{
        @JvmStatic
        fun build(user: User): UserPrinciple{
            val l= arrayListOf<String>(user.role)
            val grantedAuthority:Collection<GrantedAuthority> = l.map { SimpleGrantedAuthority(it) }
            return UserPrinciple(user.id,user.username,user.email,user.password,user.isEnabled,grantedAuthority)

        }
    }

}

