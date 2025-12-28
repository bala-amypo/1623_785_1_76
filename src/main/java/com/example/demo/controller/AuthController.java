// package com.example.demo.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @PostMapping("/login")
//     public ResponseEntity<String> login(@RequestParam String username,
//                                         @RequestParam String password) {

//         // Temporary mock check (replace with real DB logic later)
//         if ("user".equals(username) && "pass".equals(password)) {
//             return ResponseEntity.ok("Login successful");
//         } else {
//             return ResponseEntity.status(401).body("Please log in");
//         }
//     }
// }


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

    // In-memory user store
    private final List<User> users = new ArrayList<>();

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;

        // Add default user
        users.add(new User("user", "pass", "user@example.com"));
    }

    // REGISTER
    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        // Check if username already exists
        boolean exists = users.stream()
                .anyMatch(u -> u.getUsername().equals(user.getUsername()));

        if (exists) {
            return new AuthResponse("Username already exists", null);
        }

        users.add(user);
        return new AuthResponse("User registered successfully", null);
    }

    // LOGIN
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
