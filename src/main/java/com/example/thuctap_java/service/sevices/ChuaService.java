package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.ChuaConverter;
import com.example.thuctap_java.Converter.DaoTrangConverter;
import com.example.thuctap_java.dto.DTO.ChuaDTO;
import com.example.thuctap_java.dto.DTO.DaoTrangDT0;
import com.example.thuctap_java.dto.request.ThemChuaRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.repository.ChuaRepo;
import com.example.thuctap_java.repository.DaoTrangRepo;
import com.example.thuctap_java.service.iservice.iChuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChuaService implements iChuaService {
    @Autowired
    private ChuaRepo chuaRepo;
    @Autowired
    private ChuaConverter chuaConverter;
    private ResponseObject<ChuaDTO> ChuaDTOResponseObject;

    public ChuaService() {
        ChuaDTOResponseObject = new ResponseObject<ChuaDTO>();
    }
    @Override
    public ResponseObject<ChuaDTO> themChua(ThemChuaRequest request) {
        var themchua = chuaConverter.themChua(request);
        chuaRepo.save(themchua);
        return ChuaDTOResponseObject.responseSuccess("Thêm chùa thành công", chuaConverter.entityToDTO(themchua));
    }
}
