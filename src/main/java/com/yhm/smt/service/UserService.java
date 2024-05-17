package com.yhm.smt.service;

import com.yhm.smt.dto.UserDto;
import com.yhm.smt.entity.User;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void updateUser(UserDto user) {
        User updateUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new ResourceNotFoundException("User not exist with username " + user.getUsername()));
        updateUser.setUsername(user.getUsername());
        if (!user.getPassword().isBlank()) {
            updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(updateUser);


    }
}
