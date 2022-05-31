package ru.smaliav.voting.infrastructure.integration.exception

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.http.HttpStatus

@JsonPropertyOrder(
    "code",
    "status",
    "reason",
)
class ExceptionResponse(
    httpStatus: HttpStatus,
    val reason: String?,
) {
    val code = httpStatus.value()
    val status = httpStatus.reasonPhrase
}
