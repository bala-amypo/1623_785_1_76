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
import com.example.demo.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {

        AuthResponse response = new AuthResponse();

        // mock register
        response.setMessage("User registered successfully");
        response.setToken(null);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        AuthResponse response = new AuthResponse();

        // mock authentication
        if ("user".equals(request.getUsername())
                && "pass".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());

            response.setMessage("Login successful");
            response.setToken(token);
            return ResponseEntity.ok(response);
        }

        response.setMessage("Invalid credentials");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }
}
