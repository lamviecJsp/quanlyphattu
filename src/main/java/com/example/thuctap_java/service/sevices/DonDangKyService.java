package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.DonDangKyConverter;
import com.example.thuctap_java.dto.DTO.DonDanKyDTO;
import com.example.thuctap_java.dto.request.SuaDonDangKyRequest;
import com.example.thuctap_java.dto.request.ThemDonDangKyRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.entity.DaoTrang;
import com.example.thuctap_java.entity.DonDangKy;
import com.example.thuctap_java.repository.DaoTrangRepo;
import com.example.thuctap_java.repository.DonDangKysRepo;
import com.example.thuctap_java.service.iservice.iDonDangKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DonDangKyService implements iDonDangKyService {
    @Autowired
    private DonDangKysRepo donDangKysRepo;
    @Autowired
    private DonDangKyConverter donDangKyConverter;
    @Autowired
    private DaoTrangRepo daoTrangRepo;
    private ResponseObject<DonDanKyDTO> DonDanKyDTOResponseObject;

    public DonDangKyService() {
        DonDanKyDTOResponseObject = new ResponseObject<DonDanKyDTO>();
    }

    @Override
    public ResponseObject<DonDanKyDTO> themDonDangKy(ThemDonDangKyRequest request) {
        var themddk = donDangKyConverter.themDonDangKy(request);
        donDangKysRepo.save(themddk);
        return DonDanKyDTOResponseObject.responseSuccess("Thêm đơn dăng ký thành công", donDangKyConverter.entityToDTO(themddk));

    }

    @Override
    public String suaDonDangKy(int donDangKyId, SuaDonDangKyRequest request) {
        var ddk = donDangKysRepo.findAll().stream().filter(x -> x.getId() == donDangKyId).findFirst();
        if (ddk.isEmpty()) {
            return "Đơn đăng ký không tồn tại";
        }
        var suaddk = donDangKyConverter.suaDonDangKy(ddk.get(), request);
        donDangKysRepo.save(suaddk);
        return "Sửa thành công ";
    }

    @Override
    public String xoaDonDangKy(int donDangKyId) {
        var ddk = donDangKysRepo.findAll().stream().filter(x -> x.getId() == donDangKyId).findFirst();
        if (ddk.isEmpty()) {
            return "Đơn đăng ký không tồn tại";
        }
        donDangKysRepo.delete(ddk.get());
        return "Xoá thành công";
    }

    public void approveDonDangKy(int donDangKyId) {
        // Lấy thông tin đơn đăng ký từ ID
        Optional<DonDangKy> optionalDon = donDangKysRepo.findById(donDangKyId);

        optionalDon.ifPresent(donDangKy -> {
            // Kiểm tra và duyệt đơn đăng ký
            if (!donDangKy.isApproved()) {
                donDangKy.setApproved(true); // Đánh dấu đơn đã được duyệt

                // Tăng số lượng người tham gia trong bảng đạo tràng
                DaoTrang daoTrang = donDangKy.getDaoTrang();
                daoTrang.setSoThanhVienThamGia(daoTrang.getSoThanhVienThamGia() + 1);

                // Lưu thay đổi vào cả hai bảng
                daoTrangRepo.save(daoTrang);
                donDangKysRepo.save(donDangKy);
            }
        });
    }

    @Override
    public List<DonDangKy> timkiem(String nguoiXuLy) {
        List<DonDangKy> list = new ArrayList<>();
        for (DonDangKy donDangKy : donDangKysRepo.findAll()) {
            if (donDangKy.getNguoiXuLy().toLowerCase().contains(nguoiXuLy.toLowerCase())) {
                list.add(donDangKy);
            }
        }
        return list;
    }

    @Override
    public Set<DonDanKyDTO> phantrang(int PageSize, int PageNumber) {
        return donDangKysRepo.findAll().stream().skip((PageNumber - 1) * PageSize).limit(PageSize).map(x -> donDangKyConverter.entityToDTO(x)).collect(Collectors.toSet());
    }
}
