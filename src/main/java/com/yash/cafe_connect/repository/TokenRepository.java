package com.yash.cafe_connect.repository;

import com.yash.cafe_connect.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findTopByDateOrderByTokenNumberDesc(LocalDate date);
    List<Token> findByUserId(Long userId);
}