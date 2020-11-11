package com.project.management.controller

import com.project.management.model.ResponseMessage
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler
    protected fun handleConflict(exception: ConstraintViolationException, request: WebRequest): ResponseEntity<ResponseMessage> {
        System.out.println(exception.constraintName)
        if (exception.constraintName.equals("username_unique_constraint")) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY) //TODO check status codes
                    .body<ResponseMessage>(ResponseMessage("There is already an account with this email!"))
        }
        return ResponseEntity.badRequest().body<ResponseMessage>(ResponseMessage("Some constraint is violated"))
    }
}
