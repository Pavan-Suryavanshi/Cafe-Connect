package com.yash.cafe_connect.service;

import com.yash.cafe_connect.entity.Token;

import java.util.List;

public interface TokenService {

    Token createToken(Long userId, Long thaliId, Boolean paid);

    List<Token> getAllTokens();
    List<Token> getTokensByUser(Long userId);
}