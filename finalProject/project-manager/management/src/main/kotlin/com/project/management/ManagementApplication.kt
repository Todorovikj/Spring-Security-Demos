package com.project.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

<<<<<<< HEAD
@SpringBootApplication(exclude=[SecurityAutoConfiguration::class])
=======


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
>>>>>>> 068db1e5a6436414359925805188f996377fb4fc
class ManagementApplication

fun main(args: Array<String>) {
    runApplication<ManagementApplication>(*args)
}

