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
