package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.DaoTrangDT0;
import com.example.thuctap_java.dto.DTO.DonDanKyDTO;
import com.example.thuctap_java.dto.request.SuaDaoTrangRequest;
import com.example.thuctap_java.dto.request.SuaDonDangKyRequest;
import com.example.thuctap_java.dto.request.ThemDaoTrangRequest;
import com.example.thuctap_java.dto.request.ThemDonDangKyRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.entity.DonDangKy;

import java.util.List;
import java.util.Set;

public interface iDonDangKyService {
    ResponseObject<DonDanKyDTO> themDonDangKy(ThemDonDangKyRequest request);

    String suaDonDangKy(int donDangKyId, SuaDonDangKyRequest request);

    String xoaDonDangKy(int donDangKyId);

    List<DonDangKy> timkiem(String nguoiXuLy);

    Set<DonDanKyDTO> phantrang(int PageSize, int PageNumber);
}
