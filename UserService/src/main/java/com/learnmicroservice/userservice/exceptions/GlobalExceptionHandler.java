package com.learnmicroservice.userservice.exceptions;

import com.learnmicroservice.userservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
           String message = ex.getMessage();
           APIResponse apiResponse = new APIResponse();
           apiResponse.setMessage(message);
           apiResponse.setStatus(HttpStatus.NOT_FOUND);
           apiResponse.setSuccess(true);
           return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
