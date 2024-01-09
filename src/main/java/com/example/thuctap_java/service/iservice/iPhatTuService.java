package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.dto.DTO.PhatTuDTO;
import com.example.thuctap_java.entity.PhatTu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface iPhatTuService {
    Page<PhatTu> findByTenTaiKhoanContainingAndEmailContainingAndGioiTinh(
            String tenTaiKhoan, String email, String gioiTinh, int PageSize, int PageNumber
    );
}
