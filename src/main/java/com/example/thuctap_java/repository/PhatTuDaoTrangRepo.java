package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.PhatTuDaoTrang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhatTuDaoTrangRepo extends JpaRepository<PhatTuDaoTrang,Integer> {
}
