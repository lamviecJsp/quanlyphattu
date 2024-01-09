package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.DaoTrangDT0;
import com.example.thuctap_java.dto.request.SuaDaoTrangRequest;
import com.example.thuctap_java.dto.request.ThemDaoTrangRequest;
import com.example.thuctap_java.entity.DaoTrang;
import org.springframework.stereotype.Component;

@Component
public class DaoTrangConverter {
    public DaoTrangDT0 entityToDTO(DaoTrang daoTrang){
        DaoTrangDT0 dto=new DaoTrangDT0();
        dto.setDaKetThuc(daoTrang.getDaKetThuc());
        dto.setNoiDung(daoTrang.getNoiDung());
        dto.setNguoiChuTri(daoTrang.getNguoiChuTri());
        dto.setThoiGianBatDau(daoTrang.getThoiGianBatDau());
        dto.setNoiToChuc(daoTrang.getNoiToChuc());
        dto.setSoThanhVienThamGia(daoTrang.getSoThanhVienThamGia());
        return dto;
    }

    public DaoTrang  themDaoTrang(ThemDaoTrangRequest request){
        DaoTrang daoTrang=  new DaoTrang();
        daoTrang.setDaKetThuc(request.getDaKetThuc());
        daoTrang.setNoiDung(request.getNoiDung());
        daoTrang.setNguoiChuTri(request.getNguoiChuTri());
        daoTrang.setThoiGianBatDau(request.getThoiGianBatDau());
        daoTrang.setNoiToChuc(request.getNoiToChuc());
        daoTrang.setSoThanhVienThamGia(request.getSoThanhVienThamGia());
        return daoTrang;
    }
    public DaoTrang  suaDaoTrang(DaoTrang daoTrang, SuaDaoTrangRequest request){
        daoTrang.setDaKetThuc(request.getDaKetThuc());
        daoTrang.setNoiDung(request.getNoiDung());
        daoTrang.setNguoiChuTri(request.getNguoiChuTri());
        daoTrang.setThoiGianBatDau(request.getThoiGianBatDau());
        daoTrang.setNoiToChuc(request.getNoiToChuc());
        daoTrang.setSoThanhVienThamGia(request.getSoThanhVienThamGia());
        return daoTrang;
    }

}
