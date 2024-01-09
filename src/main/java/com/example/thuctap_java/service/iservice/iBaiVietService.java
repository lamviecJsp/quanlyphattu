package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.BaiVietDTO;
import com.example.thuctap_java.dto.request.ThemBaiVietRequest;
import com.example.thuctap_java.dto.response.ResponseObject;

public interface iBaiVietService {
    ResponseObject<BaiVietDTO>  taoBaiViet(ThemBaiVietRequest request);

    String xoaBaiViet(int baiVietId);
}
