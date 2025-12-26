package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final Map<String, UserPrincipal> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UserPrincipal register(String email, String password, String role) {
        Long id = idGenerator.getAndIncrement();
        UserPrincipal user = new UserPrincipal(id, email, password, role);
        users.put(email, user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipal user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}