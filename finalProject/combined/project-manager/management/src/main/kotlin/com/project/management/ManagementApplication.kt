package com.project.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication



@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class ManagementApplication

fun main(args: Array<String>) {
    runApplication<ManagementApplication>(*args)
}

