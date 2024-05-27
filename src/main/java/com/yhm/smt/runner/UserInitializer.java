package com.yhm.smt.runner;

import com.yhm.smt.entity.User;
import com.yhm.smt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        // Check if user already exists
        if (userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setId(1);
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("4xylbrPg5rHLSy0"));
            userRepository.save(user);
            System.out.println("Default user created");
        } else {
            System.out.println("User already exists");
        }
    }
}
