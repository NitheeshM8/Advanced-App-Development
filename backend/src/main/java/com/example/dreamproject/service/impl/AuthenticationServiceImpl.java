package com.example.dreamproject.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dreamproject.dto.request.LoginRequest;
import com.example.dreamproject.dto.request.RegisterRequest;
import com.example.dreamproject.dto.response.LoginResponse;
import com.example.dreamproject.dto.response.RegisterResponse;
import com.example.dreamproject.entity.User;
import com.example.dreamproject.repository.UserRepo;
import com.example.dreamproject.service.AuthenticationService;
import com.example.dreamproject.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UserRepo usersRepository;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return RegisterResponse.builder()
                    .message("Password and ConfirmPassword do not match")
                    .build();
        }

        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(com.example.dreamproject.enumerated.Role.USER)
                .build();
        usersRepository.save(user);
        return RegisterResponse.builder()
                .message("User registered successfully")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
            authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            var user = usersRepository.findByEmail(request.getEmail()).orElseThrow();

                    var token = jwtUtil.generateToken(user);
        return LoginResponse.builder()
                .message("Logged in successfully.")
                .token(token)
                .build();
    }

}
