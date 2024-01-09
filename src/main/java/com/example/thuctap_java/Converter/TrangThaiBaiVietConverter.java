package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.TrangThaiBaiVietDTO;
import com.example.thuctap_java.dto.request.ThemTrangThaiBaiVietRequest;
import com.example.thuctap_java.entity.TrangThaiBaiViet;
import org.springframework.stereotype.Component;

@Component
public class TrangThaiBaiVietConverter {
    public TrangThaiBaiVietDTO entityToDTO(TrangThaiBaiViet trangThaiBaiViet){
        TrangThaiBaiVietDTO dto = new TrangThaiBaiVietDTO();
        dto.setTenTrangThai(trangThaiBaiViet.getTenTrangThai());
        return dto;
    }
    public TrangThaiBaiViet themTrangThaiBaiViet (ThemTrangThaiBaiVietRequest request){
        TrangThaiBaiViet trangThaiBaiViet = new TrangThaiBaiViet();
        trangThaiBaiViet.setTenTrangThai(request.getTenTrangThai());
        return trangThaiBaiViet;
    }
}
