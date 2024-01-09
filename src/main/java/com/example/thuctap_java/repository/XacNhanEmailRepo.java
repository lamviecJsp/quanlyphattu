package com.example.thuctap_java.repository;

import com.example.thuctap_java.entity.XacNhanEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XacNhanEmailRepo extends JpaRepository<XacNhanEmail,Integer> {
}
