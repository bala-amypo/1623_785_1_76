// package com.example.demo.dto;

// public class AuthResponse {
//     private String token;

//     public AuthResponse(String token) {
//         this.token = token;
//     }

//     public String getToken() { return token; }
//     public void setToken(String token) { this.token = token; }
// }

package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String message;
    private String token;
}
