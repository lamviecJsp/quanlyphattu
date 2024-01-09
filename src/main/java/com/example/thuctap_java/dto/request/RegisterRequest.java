package com.example.thuctap_java.dto.request;

import com.example.thuctap_java.entity.QuyenHan;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {
    private String tenTaiKhoan;
    private String email;
    private String matKhau;
    private String soDienDhoai;
    private int chuaId;
    private int quyenHanId;
}
