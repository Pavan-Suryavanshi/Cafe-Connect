package com.yash.cafe_connect.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
