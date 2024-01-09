package com.example.thuctap_java.dto.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ThemDonDangKyRequest {
    private LocalDate ngayGuiDon;
    private LocalDate ngayXuLy;
    private String nguoiXuLy;
    private int trangThaiDonId;
    private int daoTrangId;
    private int phatTuId;
}
