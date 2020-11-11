package com.project.management.controller

import com.project.management.utils.loggerFor
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/public")
class ApiPublicController() {

    val logger = loggerFor<ApiPublicController>()


    @GetMapping("/success/{registrationId}")
    fun loginSuccess(@PathVariable registrationId: String, authenticationToken: OAuth2AuthenticationToken?) {
        logger.info("Login success [{}] - [{}]", registrationId, authenticationToken)
    }
}
