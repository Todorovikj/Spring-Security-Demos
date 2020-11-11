package com.project.management.configuration

import com.project.management.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class WebConfig(val userService: UserService,val encoder:PasswordEncoderConfiguration): WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService).passwordEncoder(encoder.passwordEncoder())
    }

//    @Throws(Exception::class)
//    override fun configure(web: WebSecurity?) {
//        super.configure(web)
//    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http    .authorizeRequests()
                .antMatchers("/api/account/register","/api/account/login","/api/logout","/login?logout").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
//                .logout().permitAll()
//                .logoutUrl("/api/logout")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
                .logout().permitAll().logoutRequestMatcher(AntPathRequestMatcher("/api/logout", "POST"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler())
                //.logoutSuccessUrl("/")
                .and()
                .httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
                .csrf().disable()

    }
    @Bean
    fun logoutSuccessHandler():LogoutSuccessHandler=CustomLogoutSuccessHandler()

}
