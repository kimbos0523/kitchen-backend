package com.example.demo.controller;

import com.example.demo.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RestController
public class UserRestController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO userDTO) {
        userService.register(userDTO);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(userService.login(loginDTO));

    }
}


