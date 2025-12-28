// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final String SECRET_KEY = "my-secret-key";
//     private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String extractUsername(String token) {
//         return Jwts.parser()
//                 .setSigningKey(SECRET_KEY)
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getSubject();
//     }
// }


package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(key)
                .compact();
    }
}
