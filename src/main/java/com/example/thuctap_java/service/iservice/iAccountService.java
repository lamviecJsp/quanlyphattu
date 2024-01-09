package com.example.thuctap_java.service.iservice;


import com.example.thuctap_java.dto.request.LoginRequest;
import com.example.thuctap_java.dto.request.RegisterRequest;
import com.example.thuctap_java.dto.response.MessageReponse;
import com.example.thuctap_java.dto.response.TokenResponse;

public interface iAccountService {
    TokenResponse login(LoginRequest loginRequest);
    MessageReponse register(RegisterRequest registerRequest) throws Exception;
}
