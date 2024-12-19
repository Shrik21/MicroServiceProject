package com.learnmicroservice.ratingapplication.exception;

import com.learnmicroservice.ratingapplication.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        APIResponse apiResponse = new APIResponse(message, HttpStatus.NOT_FOUND, true);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
