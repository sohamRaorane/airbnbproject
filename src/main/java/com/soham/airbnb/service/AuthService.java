package com.soham.airbnb.service;

import com.soham.airbnb.dto.request.LoginRequest;
import com.soham.airbnb.dto.request.SignUpRequest;

public interface AuthService {
    void register(SignUpRequest request);
    String login (LoginRequest request);

}
