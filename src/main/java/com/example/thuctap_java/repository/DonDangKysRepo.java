package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.DonDangKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonDangKysRepo extends JpaRepository<DonDangKy,Integer> {
}
