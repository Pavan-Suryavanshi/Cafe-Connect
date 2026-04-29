package com.yash.cafe_connect.service.impl;

import com.yash.cafe_connect.entity.Token;
import com.yash.cafe_connect.entity.User;
import com.yash.cafe_connect.entity.Thali;
import com.yash.cafe_connect.exception.ResourceNotFoundException;
import com.yash.cafe_connect.repository.TokenRepository;
import com.yash.cafe_connect.repository.UserRepository;
import com.yash.cafe_connect.repository.ThaliRepository;
import com.yash.cafe_connect.service.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final ThaliRepository thaliRepository;

    public TokenServiceImpl(TokenRepository tokenRepository,
                            UserRepository userRepository,
                            ThaliRepository thaliRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.thaliRepository = thaliRepository;
    }

    @Override
    public Token createToken(Long userId, Long thaliId, Boolean paid) {

        // ✅ Fetch user
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + userId));

        // ✅ Fetch thali
        Thali thali = thaliRepository.findById(thaliId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Thali not found with id: " + thaliId));

        // ✅ Current date
        LocalDate today = LocalDate.now();

        // ✅ Generate next token number (per day)
        Integer nextTokenNumber = tokenRepository
                .findTopByDateOrderByTokenNumberDesc(today)
                .map(token -> token.getTokenNumber() + 1)
                .orElse(1);

        // ✅ Create token
        Token token = new Token();
        token.setUser(user);
        token.setThali(thali);
        token.setPaid(paid);
        token.setDate(today);
        token.setTokenNumber(nextTokenNumber);

        // ✅ Save to DB
        return tokenRepository.save(token);
    }

    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    @Override
    public List<Token> getTokensByUser(Long userId) {

        // Optional validation
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        return tokenRepository.findByUserId(userId);
    }
}