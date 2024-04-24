package com.app.xmartbe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.xmartbe.dto.response.ErrorResponseDTO;
import com.app.xmartbe.exception.classes.DataNotFoundException;

@RestControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleDataNotFoundException(DataNotFoundException e) {
        return new ErrorResponseDTO(
                e.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }
}
