package com.example.thuctap_java.service.iservice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface iPhatTuDetailService {
    public UserDetails loadPhatTuByTenPhatTu(String tenTaiKhoan) throws UsernameNotFoundException;
}
