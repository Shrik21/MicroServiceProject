package com.learnmicroservice.apigateway.models.AuthResponse;

import lombok.Builder;
import lombok.Data;

import javax.xml.transform.sax.SAXResult;
import java.util.Collection;

@Data
@Builder
public class AuthResponse {
    private String message;
    private String userId;
    private String refreshToken;
    private String expireAt;
    private Collection<String> authorities;
}
