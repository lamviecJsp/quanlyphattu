package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.LoaiBaiVietDTO;
import com.example.thuctap_java.dto.request.SuaLoaiBaiVietRequest;
import com.example.thuctap_java.dto.request.ThemLoaiBaiVietRequest;
import com.example.thuctap_java.dto.response.ResponseObject;

public interface iLoaiBaiVietService {
    ResponseObject<LoaiBaiVietDTO> themLoaiBaiViet(ThemLoaiBaiVietRequest request);

    String suaLoaiBaiViet(int loaiBaiVietId, SuaLoaiBaiVietRequest request);

    String xoaLoaiBaiViet(int loaiBaiVietId);
}
