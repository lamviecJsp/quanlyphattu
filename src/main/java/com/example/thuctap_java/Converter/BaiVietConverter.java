package com.example.thuctap_java.Converter;

import com.example.thuctap_java.dto.DTO.BaiVietDTO;
import com.example.thuctap_java.dto.request.ThemBaiVietRequest;
import com.example.thuctap_java.entity.BaiViet;
import org.springframework.stereotype.Component;

@Component
public class BaiVietConverter {
    public BaiVietDTO entityToDTO (BaiViet baiViet){
        BaiVietDTO dto = new BaiVietDTO();
        dto.setLoaiBaiVietId(baiViet.getLoaiBaiVietId());
        dto.setMoTa(baiViet.getMoTa());
        dto.setDaXoa(baiViet.isDaXoa());
        dto.setNguoiDuyetBaiVietId(baiViet.getNguoiDuyetBaiVietId());
        dto.setNoiDung(baiViet.getNoiDung());
        dto.setPhatTuId(baiViet.getPhatTuId());
        dto.setSoLuotThich(baiViet.getSoLuotThich());
        dto.setTieuDe(baiViet.getTieuDe());
        dto.setThoiGianDang(baiViet.getThoiGianDang());
        dto.setThoiGianCapNhat(baiViet.getThoiGianCapNhat());
        dto.setThoiGianXoa(baiViet.getThoiGianXoa());
        dto.setSoLuotBinhLuan(baiViet.getSoLuotBinhLuan());
        dto.setTrangThaiBaiVietId(baiViet.getTrangThaiBaiVietId());
        return dto;
    }

    public BaiViet themBaiViet(ThemBaiVietRequest request){
        BaiViet baiViet = new BaiViet();
        baiViet.setLoaiBaiVietId(request.getLoaiBaiVietId());
        baiViet.setMoTa(request.getMoTa());
        baiViet.setDaXoa(request.isDaXoa());
        baiViet.setNguoiDuyetBaiVietId(request.getNguoiDuyetBaiVietId());
        baiViet.setNoiDung(request.getNoiDung());
        baiViet.setPhatTuId(request.getPhatTuId());
        baiViet.setSoLuotThich(request.getSoLuotThich());
        baiViet.setTieuDe(request.getTieuDe());
        baiViet.setThoiGianDang(request.getThoiGianDang());
        baiViet.setThoiGianCapNhat(request.getThoiGianCapNhat());
        baiViet.setThoiGianXoa(request.getThoiGianXoa());
        baiViet.setSoLuotBinhLuan(request.getSoLuotBinhLuan());
        baiViet.setTrangThaiBaiVietId(request.getTrangThaiBaiVietId());
        return baiViet;
    }
}
