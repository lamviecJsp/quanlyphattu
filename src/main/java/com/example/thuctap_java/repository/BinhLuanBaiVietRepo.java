package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.BinhLuanBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BinhLuanBaiVietRepo extends JpaRepository<BinhLuanBaiViet,Integer> {
    Set<BinhLuanBaiViet> findByBaiVietId(int baiVietId);
}
