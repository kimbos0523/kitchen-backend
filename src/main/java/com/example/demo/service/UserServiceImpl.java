package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapperImpl;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
    private final UserMapperImpl userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    
	@Override
	public void register(UserDTO userDTO) {
        User user = userMapper.fromUserDTO(userDTO);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
	}

	@Override
	public AuthenticationResponse login(LoginDTO loginDTO) {
		authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );
        var user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getFirstName() + " " + user.getLastName())
                .build();
	}

}
