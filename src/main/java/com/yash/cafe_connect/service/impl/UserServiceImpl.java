package com.yash.cafe_connect.service.impl;

import com.yash.cafe_connect.dto.UserResponseDTO;
import com.yash.cafe_connect.entity.User;
import com.yash.cafe_connect.repository.UserRepository;
import com.yash.cafe_connect.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        // Force every registration as USER
        user.setRole("USER");

        return userRepository.save(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getRole()
                ))
                .toList();
    }
}