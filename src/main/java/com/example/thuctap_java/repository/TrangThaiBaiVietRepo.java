package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.TrangThaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiBaiVietRepo extends JpaRepository<TrangThaiBaiViet,Integer> {
}
