package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.DaoTrang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoTrangRepo extends JpaRepository<DaoTrang,Integer> {
}
