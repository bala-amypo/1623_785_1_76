package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;


    private final List<User> users = new ArrayList<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;


        users.add(new User("user", "pass", "user@example.com"));
    }


    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {

        boolean exists = users.stream()
                .anyMatch(u -> u.getUsername().equals(user.getUsername()));

        if (exists) {
            return new AuthResponse("Username already exists", null);
        }

        users.add(user);
        return new AuthResponse("User registered successfully", null);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        Optional<User> user = users.stream()
                .filter(u -> u.getUsername().equals(request.getUsername()) &&
                             u.getPassword().equals(request.getPassword()))
                .findFirst();

        if (user.isEmpty()) {
            return new AuthResponse("Invalid credentials", null);
        }

        String token = jwtUtil.generateToken(user.get().getUsername());
        return new AuthResponse("Login successful", token);
    }

        }