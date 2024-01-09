package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.NguoiDungThichBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungThichBaiVietRepo extends JpaRepository<NguoiDungThichBaiViet,Integer> {
    NguoiDungThichBaiViet findByPhatTuIdAndBaiVietId(int phatTuId, int baiVietId);

    int countByBaiVietId(int baiVietId);
}
