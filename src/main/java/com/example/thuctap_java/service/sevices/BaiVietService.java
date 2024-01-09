package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.BaiVietConverter;
import com.example.thuctap_java.dto.DTO.BaiVietDTO;
import com.example.thuctap_java.dto.request.ThemBaiVietRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.repository.BaiVietRepo;
import com.example.thuctap_java.service.iservice.iBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BaiVietService implements iBaiVietService {
  @Autowired
  private BaiVietRepo baiVietRepo;
  @Autowired
  private BaiVietConverter baiVietConverter;

  @Autowired
  private AuthenticationService authenticationService;
    private ResponseObject<BaiVietDTO> BaiVietDTOResponseObject;

    public BaiVietService() {
        BaiVietDTOResponseObject = new ResponseObject<BaiVietDTO>();
    }

//    @PreAuthorize("hasRole('ADMIN') or (#baiViet.phatTuId == principal.id)")
    public ResponseObject<BaiVietDTO> taoBaiViet(ThemBaiVietRequest request) {
        var loggedInUser = authenticationService.getLoggedInUser();
        if (loggedInUser != null) {
            var thembv = baiVietConverter.themBaiViet(request);
            // Gán phatTuId cho thembv nếu cần thiết: thembv.setPhatTuId(loggedInUser.getId());
            baiVietRepo.save(thembv);
            return BaiVietDTOResponseObject.responseSuccess("Thêm bài viết thành công", baiVietConverter.entityToDTO(thembv));
        } else {
            return BaiVietDTOResponseObject.responseFailed("Người dùng chưa đăng nhập", null);
        }
    }


//    @Override
//    public void deleteBaiVietById(int baiVietId) {
//        PhatTu dangNhapTrongPhatTu= authenticationService.getLoggedInUser();
//        BaiViet baiViet = baiVietRepo.findById(baiVietId).orElse(null);
//        if (baiViet != null && dangNhapTrongPhatTu != null && baiViet.getPhatTuId() == dangNhapTrongPhatTu.getId()) {
//            // Kiểm tra id của người tạo bài viết trước khi xóa
//            baiVietRepo.delete(baiViet);
//        } else {
//            // Xử lý lỗi hoặc thông báo không có quyền thực hiện thao tác này
//            throw new AuthenticationServiceException("Bạn không có quyền tạo bài viết.");
//        }
//    }

    @Override
    public String xoaBaiViet(int baiVietId) {
        var baiViet = baiVietRepo.findAll().stream().filter(x -> x.getId() == baiVietId).findFirst();
        if (baiViet.isEmpty()) {
            return "Bai viết không tồn tại";
        }
        baiVietRepo.delete(baiViet.get());
        return "Xoá thành công";
    }
}
