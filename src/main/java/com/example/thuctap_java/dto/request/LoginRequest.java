package com.example.thuctap_java.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String tenTaiKhoan;
    private String matKhau;
}
