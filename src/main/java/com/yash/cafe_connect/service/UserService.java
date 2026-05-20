package com.yash.cafe_connect.service;

import com.yash.cafe_connect.dto.UserResponseDTO;
import com.yash.cafe_connect.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<UserResponseDTO> getAllUsers();
}