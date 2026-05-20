package com.yash.cafe_connect.service;

import com.yash.cafe_connect.dto.TokenResponseDTO;
import com.yash.cafe_connect.entity.Token;

import java.util.List;

public interface TokenService {

    Token createToken(Long userId, Long thaliId, Boolean paid);

    List<TokenResponseDTO> getAllTokens();
    List<TokenResponseDTO> getTokensByUser(Long userId);
}