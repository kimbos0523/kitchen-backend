package com.example.demo.service;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

public interface UserService {
	public void register(UserDTO userDTO);

    public AuthenticationResponse login(LoginDTO loginDTO);

    //public Optional<User> findByUsername(String username);

}
