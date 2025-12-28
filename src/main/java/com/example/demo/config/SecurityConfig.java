









// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             // Disable CSRF for Postman/Swagger testing
//             .csrf(csrf -> csrf.disable())
            
//             // Authorization rules
//             .authorizeHttpRequests(auth -> auth
//                 // Swagger access for both roles
//                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").hasAnyRole("ADMIN", "MARKETER")
                
//                 // ADMIN: full POST access
//                 .requestMatchers(
//                     "/admin/**", 
//                     "/campaigns/**", 
//                     "/influencers/**", 
//                     "/discount-codes/**", 
//                     "/sales/**", 
//                     "/roi/**", 
//                     "/users/**"
//                 ).hasRole("ADMIN")
                
//                 // MARKETER: read-only access (GET)
//                 .requestMatchers(
//                     "/campaigns/**", 
//                     "/influencers/**", 
//                     "/discount-codes/**", 
//                     "/sales/**", 
//                     "/roi/**"
//                 ).hasAnyRole("ADMIN", "MARKETER")
                
//                 // All other requests require authentication
//                 .anyRequest().authenticated()
//             )
//             .formLogin()
//             .and()
//             .logout().permitAll();

//         return http.build();
//     }

//     @Bean
//     public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//         var admin = org.springframework.security.core.userdetails.User
//                 .withUsername("admin")
//                 .password(passwordEncoder.encode("admin123"))
//                 .roles("ADMIN")
//                 .build();

//         var marketer = org.springframework.security.core.userdetails.User
//                 .withUsername("marketer")
//                 .password(passwordEncoder.encode("marketer123"))
//                 .roles("MARKETER")
//                 .build();

//         return new InMemoryUserDetailsManager(admin, marketer);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }



package com.example.demo.config;

import com.example.demo.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // JWT so CSRF off
            .csrf(csrf -> csrf.disable())

            // Stateless session
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/auth/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()
                .anyRequest().authenticated()
            )

            // JWT filter 
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
  

 
        return http.build();
    }

    // Needed for authentication manager
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
