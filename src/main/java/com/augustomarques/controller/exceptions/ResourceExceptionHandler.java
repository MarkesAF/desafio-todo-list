package com.augustomarques.controller.exceptions;


import com.augustomarques.service.exceptions.DatabaseException;
import com.augustomarques.service.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest req){
        String error = "Resource Not Found";
        HttpStatus http = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), http.value(), error,e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(http).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError>database(NotFoundException e, HttpServletRequest req){
        String error = "Database Error";
        HttpStatus http = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), http.value(), error,e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(http).body(err);
    }
}
