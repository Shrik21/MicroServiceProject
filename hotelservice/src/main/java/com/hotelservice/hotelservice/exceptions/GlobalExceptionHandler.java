package com.hotelservice.hotelservice.exceptions;


import com.hotelservice.hotelservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        APIResponse apiResponse = new APIResponse(message, true, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
