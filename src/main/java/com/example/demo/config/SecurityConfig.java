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


// package com.example.demo.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// public class SecurityConfig {

//     private final JwtFilter jwtFilter;

//     public SecurityConfig(JwtFilter jwtFilter) {
//         this.jwtFilter = jwtFilter;
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             .csrf(csrf -> csrf.disable())
//             .sessionManagement(session ->
//                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )
//             .formLogin(form -> form.disable())
//             .httpBasic(basic -> basic.disable())
//             .authorizeHttpRequests(auth -> auth
//                 // 👇 ONLY CHANGE: allow auth URLs & swagger
//                 .requestMatchers(
//                     "/auth/**",
//                     "/swagger-ui/**",
//                     "/swagger-ui.html",
//                     "/v3/api-docs/**",
//                     "/error"
//                 ).permitAll()
//                 // 👇 all other APIs need JWT
//                 .anyRequest().authenticated()
//             )
//             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }
// }



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Bean
    public class SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for stateless JWT
            .csrf(csrf -> csrf.disable())

            // Use stateless session (JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/auth/**",      // login/register endpoints
                        "/v3/api-docs/**",   // Swagger/OpenAPI if you use it
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()
                .anyRequest().authenticated()
            );
 return http.build();
    }






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