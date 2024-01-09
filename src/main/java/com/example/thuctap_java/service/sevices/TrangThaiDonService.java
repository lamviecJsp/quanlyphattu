package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.ChuaConverter;
import com.example.thuctap_java.Converter.TrangThaiDonConverter;
import com.example.thuctap_java.dto.DTO.ChuaDTO;
import com.example.thuctap_java.dto.DTO.TrangThaiDonDTO;
import com.example.thuctap_java.dto.request.ThemTrangThaiDonRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.repository.ChuaRepo;
import com.example.thuctap_java.repository.TrangThaiDonRepo;
import com.example.thuctap_java.service.iservice.ITrangThaiDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrangThaiDonService implements ITrangThaiDonService {
    @Autowired
    private TrangThaiDonRepo trangThaiDonRepo;
    @Autowired
    private TrangThaiDonConverter trangThaiDonConverter;
    private ResponseObject<TrangThaiDonDTO> TrangThaiDonDTOResponseObject;

    public TrangThaiDonService() {
        TrangThaiDonDTOResponseObject = new ResponseObject<TrangThaiDonDTO>();
    }
    @Override
    public ResponseObject<TrangThaiDonDTO> themTrangThaiDon(ThemTrangThaiDonRequest request) {
        var themttd = trangThaiDonConverter.themTrangThaiDon(request);
        trangThaiDonRepo.save(themttd);
        return TrangThaiDonDTOResponseObject.responseSuccess("Thêm trạng thái đơn thành công", trangThaiDonConverter.entityToDTO(themttd));

    }
}
