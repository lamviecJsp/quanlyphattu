package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.QuyenHan;
import com.example.thuctap_java.enumeration.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan,Integer> {

    Optional<QuyenHan> findByTenQuyenHan(RoleEnum roleEnum);
}
