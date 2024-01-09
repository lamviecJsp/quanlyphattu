package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.ChuaDTO;
import com.example.thuctap_java.dto.request.ThemChuaRequest;
import com.example.thuctap_java.entity.Chua;
import org.springframework.stereotype.Component;

@Component
public class ChuaConverter {
    public ChuaDTO entityToDTO(Chua chua){
        ChuaDTO dto = new ChuaDTO();
        dto.setNguoiChuTri(chua.getNguoiChuTri());
        dto.setTenChua(chua.getTenChua());
        dto.setDiaChi(chua.getDiaChi());
        dto.setNgayThanhLap(chua.getNgayThanhLap());
        return dto;
    }
    public Chua themChua(ThemChuaRequest request){
        Chua chua = new Chua();
        chua.setNguoiChuTri(request.getNguoiChuTri());
        chua.setTenChua(request.getTenChua());
        chua.setDiaChi(request.getDiaChi());
        chua.setNgayThanhLap(request.getNgayThanhLap());
        return chua;
    }
}
