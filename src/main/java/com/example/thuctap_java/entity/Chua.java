package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "chua_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chua extends BaseEntity{
    @Column(name = "tenchua")
    private String tenChua;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "ngaythanhlap")
    private LocalDate ngayThanhLap;
    @Column(name = "nguoichutri")
    private String nguoiChuTri;
    @OneToMany(mappedBy = "chua")
    @JsonManagedReference
    private Set<PhatTu> phatTus;
}
