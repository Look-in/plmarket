package com.plmarket.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class implements global exception handling mechanism.
 *
 * @author SShankunas
 */
@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    private static final String INTERNAL_SERVER_ERROR = "Internal server error";

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleThrowable(Throwable e) {
        log.error("Throwable: ", e);
        return new Error(INTERNAL_SERVER_ERROR);
    }

    @Value
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private class Error {
        String message;
    }

}
