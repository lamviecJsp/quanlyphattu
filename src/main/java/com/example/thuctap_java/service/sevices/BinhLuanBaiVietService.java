package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.entity.BaiViet;
import com.example.thuctap_java.entity.BinhLuanBaiViet;
import com.example.thuctap_java.repository.BaiVietRepo;
import com.example.thuctap_java.repository.BinhLuanBaiVietRepo;
import com.example.thuctap_java.service.iservice.iBinhLuanBaiVietService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BinhLuanBaiVietService implements iBinhLuanBaiVietService {
    private  final BinhLuanBaiVietRepo binhLuanBaiVietRepo;
    private final BaiVietRepo baiVietRepo;
    private Object updateNumberOfComments;

    public BinhLuanBaiVietService(BinhLuanBaiVietRepo binhLuanBaiVietRepo, BaiVietRepo baiVietRepo) {
        this.binhLuanBaiVietRepo = binhLuanBaiVietRepo;
        this.baiVietRepo = baiVietRepo;
    }

    @Override
    public BinhLuanBaiViet createBinhLuan(BinhLuanBaiViet binhLuan) {
        BinhLuanBaiViet saveBinhLuan = binhLuanBaiVietRepo.save(binhLuan);
        updateNumberOfComments(binhLuan.getBaiVietId());
        return saveBinhLuan;
    }


    @Override
    public void deleteBinhLuanById(int binhLuanId, int baiVietId) {
        binhLuanBaiVietRepo.deleteById(binhLuanId);
        updateNumberOfComments(baiVietId);
    }
    private void updateNumberOfComments(int baiVietId) {
        BaiViet baiViet = baiVietRepo.findById(baiVietId).orElse(null); // Tìm bài viết theo ID

        if (baiViet != null) {
            Set<BinhLuanBaiViet> binhLuans = binhLuanBaiVietRepo.findByBaiVietId(baiVietId); // Tìm tất cả các bình luận của bài viết

            if (binhLuans != null) {
                int numberOfComments = binhLuans.size(); // Đếm số lượng bình luận

                baiViet.setSoLuotBinhLuan(numberOfComments); // Cập nhật số lượng bình luận của bài viết
                baiVietRepo.save(baiViet); // Lưu bài viết đã cập nhật số lượng bình luận
            }
        }
    }
}
