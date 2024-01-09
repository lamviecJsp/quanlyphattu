package com.example.thuctap_java.dto.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DaoTrangDT0 {
    private Boolean daKetThuc;
    private String noiDung;
    private String noiToChuc;
    private int soThanhVienThamGia;
    private LocalDate thoiGianBatDau;
    private String nguoiChuTri;
}
