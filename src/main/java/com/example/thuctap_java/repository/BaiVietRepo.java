package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepo extends JpaRepository<BaiViet,Integer> {
}
