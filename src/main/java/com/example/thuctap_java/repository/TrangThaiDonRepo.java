package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.TrangThaiDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiDonRepo extends JpaRepository<TrangThaiDon,Integer> {
}
