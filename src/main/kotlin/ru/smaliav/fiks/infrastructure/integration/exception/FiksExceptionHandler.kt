package ru.smaliav.fiks.infrastructure.integration.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class FiksExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(e: EntityNotFoundException) = ExceptionResponse(
        HttpStatus.NOT_FOUND, e.message
    )

    @ExceptionHandler(InvalidNullException::class)
    fun handleInvalidNullException(e: InvalidNullException) = ExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, e.message
    )

}
