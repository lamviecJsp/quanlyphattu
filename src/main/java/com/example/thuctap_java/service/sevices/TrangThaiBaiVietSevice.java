package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.TrangThaiBaiVietConverter;
import com.example.thuctap_java.dto.DTO.TrangThaiBaiVietDTO;
import com.example.thuctap_java.dto.DTO.TrangThaiDonDTO;
import com.example.thuctap_java.dto.request.ThemTrangThaiBaiVietRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.repository.TrangThaiBaiVietRepo;
import com.example.thuctap_java.service.iservice.iTrangThaiBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrangThaiBaiVietSevice implements iTrangThaiBaiVietService {
    @Autowired
    private TrangThaiBaiVietRepo trangThaiBaiVietRepo;
    @Autowired
    private TrangThaiBaiVietConverter trangThaiBaiVietConverter;

    private ResponseObject<TrangThaiBaiVietDTO> TrangThaiBaiVietDTOResponseObject;

    public TrangThaiBaiVietSevice() {
        TrangThaiBaiVietDTOResponseObject = new ResponseObject<TrangThaiBaiVietDTO>();
    }


    @Override
    public ResponseObject<TrangThaiBaiVietDTO> themTrangThaiBaiViet(ThemTrangThaiBaiVietRequest request) {
        var themttbv = trangThaiBaiVietConverter.themTrangThaiBaiViet(request);
        trangThaiBaiVietRepo.save(themttbv);
        return TrangThaiBaiVietDTOResponseObject.responseSuccess("Thêm trạng thái bài viết thành công", trangThaiBaiVietConverter.entityToDTO(themttbv));


    }
}
