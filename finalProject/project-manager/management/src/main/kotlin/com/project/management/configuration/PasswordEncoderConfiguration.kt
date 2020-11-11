package com.project.management.configuration

<<<<<<< HEAD


=======
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class PasswordEncoderConfiguration {
<<<<<<< HEAD
        @Bean
        fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
=======
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
