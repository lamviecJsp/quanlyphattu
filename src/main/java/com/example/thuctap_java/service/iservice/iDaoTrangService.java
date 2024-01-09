package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.DaoTrangDT0;
import com.example.thuctap_java.dto.request.SuaDaoTrangRequest;
import com.example.thuctap_java.dto.request.ThemDaoTrangRequest;
import com.example.thuctap_java.dto.response.ResponseObject;

import java.time.LocalDate;
import java.util.Set;

public interface iDaoTrangService {
    ResponseObject<DaoTrangDT0> themDaoTrang(ThemDaoTrangRequest request);

    String SuaDaoTrang(int daoTrangId, SuaDaoTrangRequest request);

    String xoaDaoTrang(int daoTrangId);

    public Set<DaoTrangDT0> searchDaoTrang(LocalDate khoangThoiGian, String chuTri, int PageSize, int PageNumber);
}
