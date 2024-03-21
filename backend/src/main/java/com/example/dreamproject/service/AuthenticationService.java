package com.example.dreamproject.service;

import com.example.dreamproject.dto.request.LoginRequest;
import com.example.dreamproject.dto.request.RegisterRequest;
import com.example.dreamproject.dto.response.LoginResponse;
import com.example.dreamproject.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
