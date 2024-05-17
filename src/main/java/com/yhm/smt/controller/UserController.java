package com.yhm.smt.controller;


import com.yhm.smt.dto.UserDto;
import com.yhm.smt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@Validated
@RequestMapping(path = {"/api/users"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<UserDto> getUser(Principal principal) {
        return ResponseEntity.ok(UserDto.fromPrincipal(principal));
    }


    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody UserDto user) {
        userService.updateUser(user);
        return ResponseEntity.ok(user.getUsername());
    }
}
