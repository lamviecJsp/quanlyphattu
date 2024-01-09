package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.LoaiBaiVietDTO;
import com.example.thuctap_java.dto.request.SuaLoaiBaiVietRequest;
import com.example.thuctap_java.dto.request.ThemLoaiBaiVietRequest;
import com.example.thuctap_java.entity.LoaiBaiViet;
import org.springframework.stereotype.Component;

@Component
public class LoaiBaiVietConverter {
    public LoaiBaiVietDTO entityToDTO (LoaiBaiViet loaiBaiViet){
        LoaiBaiVietDTO dto = new LoaiBaiVietDTO();
        dto.setTenLoai(loaiBaiViet.getTenLoai());
        return dto;
    }
    public LoaiBaiViet themLoaiBaiViet(ThemLoaiBaiVietRequest request){
        LoaiBaiViet loaiBaiViet = new LoaiBaiViet();
        loaiBaiViet.setTenLoai(request.getTenLoai());
        return loaiBaiViet;
    }

    public LoaiBaiViet suaLoaiBaiViet(LoaiBaiViet loaiBaiViet, SuaLoaiBaiVietRequest request){
        loaiBaiViet.setTenLoai(request.getTenLoai());
        return loaiBaiViet;
    }
}
