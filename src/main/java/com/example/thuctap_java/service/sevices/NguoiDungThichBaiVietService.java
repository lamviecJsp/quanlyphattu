package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.entity.BaiViet;
import com.example.thuctap_java.entity.NguoiDungThichBaiViet;
import com.example.thuctap_java.entity.PhatTu;
import com.example.thuctap_java.repository.BaiVietRepo;
import com.example.thuctap_java.repository.NguoiDungThichBaiVietRepo;
import com.example.thuctap_java.service.iservice.iNguoiDungThichBaiVietService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class NguoiDungThichBaiVietService implements iNguoiDungThichBaiVietService {
    private final NguoiDungThichBaiVietRepo nguoiDungThichBaiVietRepo;
    private final BaiVietRepo baiVietRepo;

    private BaiViet baiViet;
    private PhatTu phatTu;

    public NguoiDungThichBaiVietService(NguoiDungThichBaiVietRepo nguoiDungThichBaiVietRepo, BaiVietRepo baiVietRepo) {
        this.nguoiDungThichBaiVietRepo = nguoiDungThichBaiVietRepo;
        this.baiVietRepo = baiVietRepo;
    }

    @Override
    public void likeBaiViet(int phatTuId, int baiVietId) {
        NguoiDungThichBaiViet like = nguoiDungThichBaiVietRepo.findByPhatTuIdAndBaiVietId(phatTuId, baiVietId);
        if (like == null) {
            NguoiDungThichBaiViet newLike = new NguoiDungThichBaiViet(phatTuId,baiVietId,LocalDate.now(),false,baiViet,phatTu);
            nguoiDungThichBaiVietRepo.save(newLike);
            updateNumberOfLikes(baiVietId);
        }
    }

    private void updateNumberOfLikes(int baiVietId) {
        BaiViet baiViet = baiVietRepo.findById(baiVietId).orElse(null);
        if (baiViet != null) {
            int numberOfLikes = nguoiDungThichBaiVietRepo.countByBaiVietId(baiVietId);
            baiViet.setSoLuotThich(numberOfLikes);
            baiVietRepo.save(baiViet);
        }
    }

    @Override
    public void unlikeBaiViet(int phatTuId, int baiVietId) {
        NguoiDungThichBaiViet like = nguoiDungThichBaiVietRepo.findByPhatTuIdAndBaiVietId(phatTuId, baiVietId);
        if (like != null) {
            nguoiDungThichBaiVietRepo.delete(like);
            updateNumberOfLikes(baiVietId);
        }
    }
}
