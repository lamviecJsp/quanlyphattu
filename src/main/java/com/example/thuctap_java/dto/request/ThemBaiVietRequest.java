package com.example.thuctap_java.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ThemBaiVietRequest {
    private int loaiBaiVietId;
    private String tieuDe;
    private String moTa;
    private String noiDung;
    private int phatTuId;
    private int nguoiDuyetBaiVietId;
    private int soLuotThich;
    private int soLuotBinhLuan;
    private LocalDate thoiGianDang;
    private LocalDate thoiGianCapNhat;
    private LocalDate thoiGianXoa;
    private boolean daXoa;
    private int trangThaiBaiVietId;
}
