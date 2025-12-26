package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF if using REST APIs
            .cors() // enable CORS (requires WebMvcConfigurer with allowedOrigins)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login").permitAll() // allow login endpoint
                .anyRequest().authenticated() // everything else needs auth
            )
            .httpBasic(); // optional: use basic auth or JWT
        return http.build();
    }
}
}