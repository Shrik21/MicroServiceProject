package com.learnmicroservice.userservice.exception;

import com.learnmicroservice.userservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> ResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        APIResponse apiResponse = APIResponse.builder()
                .message(message)
                .status(HttpStatus.NOT_FOUND)
                .success(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
