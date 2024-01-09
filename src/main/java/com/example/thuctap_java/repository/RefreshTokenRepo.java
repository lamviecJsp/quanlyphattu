package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepo extends JpaRepository<RefreshToken,Integer> {
}
