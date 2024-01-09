package com.example.thuctap_java.controller;


import com.example.thuctap_java.dto.request.LoginRequest;
import com.example.thuctap_java.dto.request.RegisterRequest;
import com.example.thuctap_java.dto.response.MessageReponse;
import com.example.thuctap_java.dto.response.TokenResponse;
import com.example.thuctap_java.exceptions.UserExistException;
import com.example.thuctap_java.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/user/")
@RestController
@ControllerAdvice
public class UserController {
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping( "login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(accountService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping( "register")
    public ResponseEntity<MessageReponse> register(@RequestBody RegisterRequest registerRequest) {
        MessageReponse messageReponse;
        try {
            messageReponse = accountService.register(registerRequest);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageReponse(e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(messageReponse, HttpStatus.OK);
    }
}
