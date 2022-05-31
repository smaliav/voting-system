package ru.smaliav.voting.infrastructure.integration.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class VoteExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(e: EntityNotFoundException) = ExceptionResponse(
        HttpStatus.NOT_FOUND, e.message
    )

    @ExceptionHandler(InvalidNullException::class)
    fun handleInvalidNullException(e: InvalidNullException): ExceptionResponse {
        e.printStackTrace() // TODO Заменить на LOGGER
        return ExceptionResponse(
            HttpStatus.INTERNAL_SERVER_ERROR, e.message
        )
    }

}
