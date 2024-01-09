package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "daotrang_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DaoTrang extends BaseEntity{
    @Column(name = "daketthuc")
    private Boolean daKetThuc;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "noitochuc")
    private String noiToChuc;
    @Column(name = "sothanhvienthamgia")
    private int soThanhVienThamGia;
    @Column(name = "thoigianbatdau")
    private LocalDate thoiGianBatDau;
    @Column(name = "nguoichutri")
    private String nguoiChuTri;
    @OneToMany(mappedBy = "daoTrang")
    @JsonManagedReference
    private Set<DonDangKy> donDangKys;
    @OneToMany(mappedBy = "daoTrang")
    @JsonManagedReference
    private Set<PhatTuDaoTrang> phatTuDaoTrangs;

}
