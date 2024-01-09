package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.DonDanKyDTO;
import com.example.thuctap_java.dto.request.SuaDonDangKyRequest;
import com.example.thuctap_java.dto.request.ThemDonDangKyRequest;
import com.example.thuctap_java.entity.DonDangKy;
import org.springframework.stereotype.Component;

@Component
public class DonDangKyConverter {
    public DonDanKyDTO entityToDTO(DonDangKy donDangKy){
        DonDanKyDTO dto = new DonDanKyDTO();
        dto.setDaoTrangId(donDangKy.getDaoTrangId());
        dto.setNgayGuiDon(donDangKy.getNgayGuiDon());
        dto.setNgayXuLy(donDangKy.getNgayXuLy());
        dto.setTrangThaiDonId(donDangKy.getTrangThaiDonId());
        dto.setPhatTuId(donDangKy.getPhatTuId());
        dto.setNguoiXuLy(donDangKy.getNguoiXuLy());
        return dto;
    }

    public DonDangKy themDonDangKy(ThemDonDangKyRequest request){
        DonDangKy donDangKy= new DonDangKy();
        donDangKy.setDaoTrangId(request.getDaoTrangId());
        donDangKy.setNgayGuiDon(request.getNgayGuiDon());
        donDangKy.setNgayXuLy(request.getNgayXuLy());
        donDangKy.setTrangThaiDonId(request.getTrangThaiDonId());
        donDangKy.setPhatTuId(request.getPhatTuId());
        donDangKy.setNguoiXuLy(request.getNguoiXuLy());
        return donDangKy;
    }

    public DonDangKy suaDonDangKy(DonDangKy donDangKy, SuaDonDangKyRequest request){
        donDangKy.setDaoTrangId(request.getDaoTrangId());
        donDangKy.setNgayGuiDon(request.getNgayGuiDon());
        donDangKy.setNgayXuLy(request.getNgayXuLy());
        donDangKy.setTrangThaiDonId(request.getTrangThaiDonId());
        donDangKy.setPhatTuId(request.getPhatTuId());
        donDangKy.setNguoiXuLy(request.getNguoiXuLy());
        return donDangKy;
    }
}
