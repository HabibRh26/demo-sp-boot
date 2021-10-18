package com.example.restapicrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestController
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity handleNoResourceFoundException(){
        ApiError error = new ApiError(404,"Resource Not Found", new Date());
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
    }
}
