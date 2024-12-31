package com.learnmicroservice.apigateway.controllers;

import com.learnmicroservice.apigateway.models.AuthResponse.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @RequestMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user
            ){
        logger.info("Login request received");
        logger.info("User ID: "+user.getName());
        logger.info("User email: "+user.getEmail());

     // Getting the authorities
     List<String> authorities =   user.getAuthorities().stream().map(grantedAuthority -> {
            logger.info("User authority: "+grantedAuthority.getAuthority());
            return grantedAuthority.getAuthority();
        }).toList();

     // Building the response
        AuthResponse authResponse = AuthResponse.builder()
                .message("Login successful")
                .userId(user.getName())
                .refreshToken(Objects.requireNonNull(client.getRefreshToken()).getTokenValue())
                .expireAt(Objects.requireNonNull(client.getAccessToken().getExpiresAt()).toString())
                .authorities(authorities)
                .build();

        return ResponseEntity.ok(authResponse);

    }
}
