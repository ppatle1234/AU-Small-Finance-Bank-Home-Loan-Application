package com.aubank.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleCustomException(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage() , HttpStatus.NOT_FOUND);
    }
}
