package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.entity.PhatTu;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public PhatTu getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof PhatTu) {
            // Nếu người dùng đã được xác thực và là một đối tượng User
            return (PhatTu) authentication.getPrincipal();
        } else {
            // Trong trường hợp không có người dùng đăng nhập hoặc không thể xác định người dùng
            return null;
        }
    }
}
