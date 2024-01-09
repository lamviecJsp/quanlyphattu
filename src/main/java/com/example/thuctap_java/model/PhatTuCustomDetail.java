package com.example.thuctap_java.model;

import com.example.thuctap_java.entity.PhatTu;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PhatTuCustomDetail implements UserDetails {

    private PhatTu phatTu;
    public PhatTuCustomDetail(PhatTu pt){
        this.phatTu = pt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((phatTu.getQuyenHan().getTenQuyenHan().name())));
    }

    @Override
    public String getPassword() {
        return phatTu.getMatKhau();
    }

    @Override
    public String getUsername() {
        return phatTu.getTenTaiKhoan();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
