package com.example.thuctap_java.service.impl;

import com.example.thuctap_java.entity.PhatTu;
import com.example.thuctap_java.model.PhatTuCustomDetail;
import com.example.thuctap_java.repository.PhatTuRepo;
import com.example.thuctap_java.service.iservice.iPhatTuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PhatTuDetailService implements  UserDetailsService {
    @Autowired
    private PhatTuRepo phatTuRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<PhatTu> findByTenTaiKhoan = phatTuRepo.findByTenTaiKhoan(username);
        return (UserDetails) PhatTuCustomDetail.builder().phatTu(findByTenTaiKhoan.get()).build();
    }
}
