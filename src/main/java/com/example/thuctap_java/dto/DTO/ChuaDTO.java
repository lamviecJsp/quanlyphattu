package com.example.thuctap_java.dto.DTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ChuaDTO {
    private String tenChua;
    private String diaChi;
    private LocalDate ngayThanhLap;
    private String nguoiChuTri;
}
