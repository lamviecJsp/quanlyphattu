package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.ChuaDTO;
import com.example.thuctap_java.dto.request.ThemChuaRequest;
import com.example.thuctap_java.dto.response.ResponseObject;

public interface iChuaService {
    ResponseObject<ChuaDTO> themChua(ThemChuaRequest request);
}
