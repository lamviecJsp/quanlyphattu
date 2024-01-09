package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.Chua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuaRepo extends JpaRepository<Chua,Integer> {
}
