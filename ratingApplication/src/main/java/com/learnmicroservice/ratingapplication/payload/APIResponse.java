package com.learnmicroservice.ratingapplication.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class APIResponse {
    private String message;
    private HttpStatus status;
    private boolean isSuccess;

    public APIResponse(String message,HttpStatus status,boolean isSuccess){
        this.message=message;
        this.status = status;
        this.isSuccess=isSuccess;
    }
}
