package com.project.management.configuration

import com.project.management.util.loggerFor
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
var logger= loggerFor<CustomLogoutSuccessHandler>()
class CustomLogoutSuccessHandler:SimpleUrlLogoutSuccessHandler(),LogoutSuccessHandler {
    override fun onLogoutSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication?) {
        logger.info("User with Session id: ${request.session} logged out")
    }
}