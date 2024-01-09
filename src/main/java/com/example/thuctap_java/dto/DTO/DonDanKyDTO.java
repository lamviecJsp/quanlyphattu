package com.example.thuctap_java.dto.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class DonDanKyDTO {

    private LocalDate ngayGuiDon;
    private LocalDate ngayXuLy;
    private String nguoiXuLy;
    private int trangThaiDonId;
    private int daoTrangId;
    private int phatTuId;
}
