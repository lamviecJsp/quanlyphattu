package com.example.thuctap_java.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ThemChuaRequest {
    private String tenChua;
    private String diaChi;
    private LocalDate ngayThanhLap;
    private String nguoiChuTri;
}
