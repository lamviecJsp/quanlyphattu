package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.LoaiBaiVietConverter;
import com.example.thuctap_java.dto.DTO.DonDanKyDTO;
import com.example.thuctap_java.dto.DTO.LoaiBaiVietDTO;
import com.example.thuctap_java.dto.request.SuaLoaiBaiVietRequest;
import com.example.thuctap_java.dto.request.ThemLoaiBaiVietRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.repository.LoaiBaiVietRepo;
import com.example.thuctap_java.service.iservice.iLoaiBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiBaiVietService implements iLoaiBaiVietService {
    @Autowired
    private  LoaiBaiVietRepo loaiBaiVietRepo;
    @Autowired
    private LoaiBaiVietConverter loaiBaiVietConverter;
    private ResponseObject<LoaiBaiVietDTO> LoaiBaiVietDTOResponseObject;

    public LoaiBaiVietService() {
        LoaiBaiVietDTOResponseObject = new ResponseObject<LoaiBaiVietDTO>();
    }


    @Override
    public ResponseObject<LoaiBaiVietDTO> themLoaiBaiViet(ThemLoaiBaiVietRequest request) {
        var themlbv = loaiBaiVietConverter.themLoaiBaiViet(request);
        loaiBaiVietRepo.save(themlbv);
        return LoaiBaiVietDTOResponseObject.responseSuccess("Thêm loại bài viết thành công", loaiBaiVietConverter.entityToDTO(themlbv));
    }

    @Override
    public String suaLoaiBaiViet(int loaiBaiVietId, SuaLoaiBaiVietRequest request) {
        var lbv = loaiBaiVietRepo.findAll().stream().filter(x -> x.getId() == loaiBaiVietId).findFirst();
        if (lbv.isEmpty()) {
            return "Loại bài viết không tồn tại";
        }
        var sualbv= loaiBaiVietConverter.suaLoaiBaiViet(lbv.get(), request);
        loaiBaiVietRepo.save(sualbv);
        return "Sửa thành công ";
    }

    @Override
    public String xoaLoaiBaiViet(int loaiBaiVietId) {
        var lbv = loaiBaiVietRepo.findAll().stream().filter(x -> x.getId() == loaiBaiVietId).findFirst();
        if (lbv.isEmpty()) {
            return "Loại bài viết không tồn tại";
        }
        loaiBaiVietRepo.delete(lbv.get());
        return "Xoá thành công";
    }
}
