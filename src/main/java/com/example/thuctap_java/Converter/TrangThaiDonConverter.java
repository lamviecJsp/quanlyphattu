package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.TrangThaiDonDTO;
import com.example.thuctap_java.dto.request.ThemTrangThaiDonRequest;
import com.example.thuctap_java.entity.TrangThaiDon;
import org.springframework.stereotype.Component;

@Component
public class TrangThaiDonConverter {
    public TrangThaiDonDTO entityToDTO(TrangThaiDon trangThaiDon){
        TrangThaiDonDTO dto = new TrangThaiDonDTO();
        dto.setTenTrangThai(trangThaiDon.getTenTrangThai());
        return dto;
    }

    public TrangThaiDon themTrangThaiDon(ThemTrangThaiDonRequest request){
        TrangThaiDon trangThaiDon= new TrangThaiDon();
        trangThaiDon.setTenTrangThai(request.getTenTrangThai());
        return trangThaiDon;
    }
}
