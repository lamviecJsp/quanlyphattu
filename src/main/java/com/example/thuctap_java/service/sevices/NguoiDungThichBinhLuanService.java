package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.entity.BinhLuanBaiViet;
import com.example.thuctap_java.entity.NguoiDungThichBinhLuanBaiViet;
import com.example.thuctap_java.entity.PhatTu;
import com.example.thuctap_java.repository.BinhLuanBaiVietRepo;
import com.example.thuctap_java.repository.NguoiDungThichBinhLuanBaiVietRepo;
import com.example.thuctap_java.service.iservice.iNguoiDungThichBinhLuanBaiVietService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NguoiDungThichBinhLuanService  implements iNguoiDungThichBinhLuanBaiVietService {
    private final NguoiDungThichBinhLuanBaiVietRepo nguoiDungThichBinhLuanBaiVietRepo;
    private final BinhLuanBaiVietRepo binhLuanBaiVietRepo;
    private BinhLuanBaiViet binhLuanBaiViet;
    private PhatTu phatTu;

    public NguoiDungThichBinhLuanService(NguoiDungThichBinhLuanBaiVietRepo nguoiDungThichBinhLuanBaiVietRepo, BinhLuanBaiVietRepo binhLuanBaiVietRepo) {
        this.nguoiDungThichBinhLuanBaiVietRepo = nguoiDungThichBinhLuanBaiVietRepo;
        this.binhLuanBaiVietRepo = binhLuanBaiVietRepo;
    }

    @Override
    public void likeBinhLuan(int phatTuId, int binhLuanBaiVietId) {
        NguoiDungThichBinhLuanBaiViet like = nguoiDungThichBinhLuanBaiVietRepo.findByPhatTuIdAndBinhLuanBaiVietId(phatTuId, binhLuanBaiVietId);
        if (like == null) {
            NguoiDungThichBinhLuanBaiViet newLike = new NguoiDungThichBinhLuanBaiViet(phatTuId, binhLuanBaiVietId, LocalDate.now(), false,binhLuanBaiViet,phatTu);
            nguoiDungThichBinhLuanBaiVietRepo.save(newLike);
            updateNumberOfLikes(binhLuanBaiVietId);
        }
    }



    @Override
    public void unlikeBinhLuan(int phatTuId, int binhLuanBaiVietId) {
        NguoiDungThichBinhLuanBaiViet like = nguoiDungThichBinhLuanBaiVietRepo.findByPhatTuIdAndBinhLuanBaiVietId(phatTuId, binhLuanBaiVietId);
        if (like != null) {
            nguoiDungThichBinhLuanBaiVietRepo.delete(like);
            updateNumberOfLikes(binhLuanBaiVietId);
        }
    }
    private void updateNumberOfLikes(int binhLuanBaiVietId) {
        BinhLuanBaiViet binhLuanBaiViet = binhLuanBaiVietRepo.findById(binhLuanBaiVietId).orElse(null);
        if (binhLuanBaiViet != null) {
            int numberOfLikes = nguoiDungThichBinhLuanBaiVietRepo.countByBinhLuanBaiVietId(binhLuanBaiVietId);
            binhLuanBaiViet.setSoLuotThich(numberOfLikes);
            binhLuanBaiVietRepo.save(binhLuanBaiViet);
        }
    }
}
