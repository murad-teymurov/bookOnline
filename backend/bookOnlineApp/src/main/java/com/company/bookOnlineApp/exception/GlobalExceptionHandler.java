package com.company.bookOnlineApp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleException(GenericException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(exception.getErrorCode());
    }

}
