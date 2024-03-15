package com.example.demo.service;

import com.example.demo.dto.response.AuthenticationResponse;
import com.example.demo.dto.request.AuthenticationRequest;
import com.example.demo.dto.request.UserRequest;

public interface UserService {
	public void register(UserRequest userRequest);

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    //public Optional<User> findByUsername(String username);

}
