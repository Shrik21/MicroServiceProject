package com.hotelservice.hotelservice.exceptions;

import com.hotelservice.hotelservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }
    public ResourceNotFoundException() {
        super("Resource not found");
    }

    @RestControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler
        public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException ex) {
            String message = ex.getMessage();
            APIResponse apiResponse = new APIResponse(message,true, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
}
