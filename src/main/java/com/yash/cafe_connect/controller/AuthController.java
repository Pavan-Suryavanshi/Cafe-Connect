package com.yash.cafe_connect.controller;

import com.yash.cafe_connect.dto.AuthRequest;
import com.yash.cafe_connect.entity.User;
import com.yash.cafe_connect.repository.UserRepository;
import com.yash.cafe_connect.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {

        User user = userRepository.findAll()
                .stream()
                .filter(u ->
                        u.getEmail().equals(authRequest.getEmail())
                                && authRequest.getPassword().equals(u.getPassword())
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        return jwtUtil.generateToken(
                user.getEmail(),
                user.getRole()
        );
    }
}