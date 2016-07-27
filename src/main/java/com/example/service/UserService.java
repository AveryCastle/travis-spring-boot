package com.example.service;

import com.example.domain.User;
import com.example.dto.UserDto;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto findOne(Long id) {
        User user = userRepository.findOne(id);

        UserDto userDto = UserDto.create(user);

        return userDto;
    }

    public UserDto save(User user) {
        User savedUser = userRepository.save(user);

        UserDto userDto = UserDto.create(savedUser);

        return userDto;
    }
}
