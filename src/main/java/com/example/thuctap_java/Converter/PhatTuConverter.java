package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.PhatTuDTO;
import com.example.thuctap_java.entity.PhatTu;
import org.springframework.stereotype.Component;

@Component
public class PhatTuConverter {
    public PhatTuDTO entityToDTO(PhatTu phatTu){
        PhatTuDTO dto = new PhatTuDTO();
        dto.setAnhChup(phatTu.getAnhChup());
        dto.setEmail(phatTu.getEmail());
        dto.setMatKhau(phatTu.getMatKhau());
        dto.setGioiTinh(phatTu.getGioiTinh());
        dto.setDaHoanTuc(phatTu.isDaHoanTuc());
        dto.setNgayCapNhat(phatTu.getNgayCapNhat());
        dto.setPhapDanh(phatTu.getPhapDanh());
        dto.setNgaySinh(phatTu.getNgaySinh());
        dto.setQuyenHanId(phatTu.getQuyenHanId());
        dto.setSoDienDhoai(phatTu.getSoDienDhoai());
        dto.setTenTaiKhoan(phatTu.getTenTaiKhoan());
        dto.setNgayHoanTuc(phatTu.getNgayHoanTuc());
        return dto;
    }
}
