// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .cors(cors -> {}) // just enable CORS
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/auth/login").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .httpBasic();
//         return http.build();
//     }
// }

// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeHttpRequests(authz -> authz.anyRequest().permitAll());
//         return http.build();
//     }
// }

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