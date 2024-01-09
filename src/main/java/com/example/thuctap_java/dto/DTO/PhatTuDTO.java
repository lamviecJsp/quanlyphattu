package com.example.thuctap_java.dto.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PhatTuDTO {
    private String tenTaiKhoan;
    private String anhChup;
    private boolean daHoanTuc;
    private String email;
    private String gioiTinh;
    private LocalDate ngayCapNhat;
    private LocalDate ngayHoanTuc;
    private LocalDate ngaySinh;
    private String matKhau;
    private String phapDanh;
    private String soDienDhoai;
    private int chuaId;
    private int quyenHanId;
}
