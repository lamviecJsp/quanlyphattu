package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.NguoiDungThichBinhLuanBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungThichBinhLuanBaiVietRepo extends JpaRepository<NguoiDungThichBinhLuanBaiViet,Integer> {
    NguoiDungThichBinhLuanBaiViet findByPhatTuIdAndBinhLuanBaiVietId(int phatTuId, int binhLuanBaiVietId);

    int countByBinhLuanBaiVietId(int binhLuanBaiVietId);
}
