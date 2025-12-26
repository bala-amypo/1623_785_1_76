package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())   // Disable CSRF for REST APIs
            .cors()                         // Enable CORS (configured in WebConfig)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login").permitAll() // Allow login endpoint
                .anyRequest().authenticated()               // Protect other endpoints
            )
            .httpBasic(); // Or use .formLogin() if you want form login
        return http.build();
    }
}
