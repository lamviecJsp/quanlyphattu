package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.TrangThaiBaiVietDTO;
import com.example.thuctap_java.dto.DTO.TrangThaiDonDTO;
import com.example.thuctap_java.dto.request.ThemTrangThaiBaiVietRequest;
import com.example.thuctap_java.dto.request.ThemTrangThaiDonRequest;
import com.example.thuctap_java.dto.response.ResponseObject;

public interface iTrangThaiBaiVietService {
    ResponseObject<TrangThaiBaiVietDTO> themTrangThaiBaiViet(ThemTrangThaiBaiVietRequest request);
}
