package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.PhatTu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhatTuRepo extends JpaRepository<PhatTu,Integer> {
    Optional<PhatTu> findByTenTaiKhoan(String tenTaiKhoan);
    Optional<PhatTu> findNguoiDungByEmailEquals(String email);
    Page<PhatTu> findByTenTaiKhoanContainingAndEmailContainingAndGioiTinh(
            String tenTaiKhoan, String email, String gioiTinh, Pageable pageable
    );
}
