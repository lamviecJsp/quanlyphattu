package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet,Integer> {
}
