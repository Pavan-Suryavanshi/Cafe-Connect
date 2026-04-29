package com.yash.cafe_connect.controller;

import com.yash.cafe_connect.entity.Token;
import com.yash.cafe_connect.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    // ✅ Create token
    @PostMapping
    public Token createToken(@RequestParam Long userId,
                             @RequestParam Long thaliId,
                             @RequestParam Boolean paid) {
        return tokenService.createToken(userId, thaliId, paid);
    }

    // ✅ Single GET method (handles both cases)
    @GetMapping
    public List<Token> getTokens(@RequestParam(required = false) Long userId) {

        // If userId is provided → filter
        if (userId != null) {
            return tokenService.getTokensByUser(userId);
        }

        // Else → return all
        return tokenService.getAllTokens();
    }
}