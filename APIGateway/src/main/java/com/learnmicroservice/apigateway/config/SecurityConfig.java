package com.learnmicroservice.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    //Implement security configuration
    //@Param httpSecurity
    //@Return SecurityWebFilterChain
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
                .authorizeExchange(exchange -> exchange
                        .anyExchange().authenticated()
                )//authorize all the requests
                .oauth2Client(withDefaults()) //configure the OAuth2 client
                .oauth2ResourceServer(resourceServer -> resourceServer
                        .jwt(withDefaults())
                ); //configure the OAuth2 resource server

        return httpSecurity.build();
    }

}
