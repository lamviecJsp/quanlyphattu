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

import java.util.Set;
@Entity
@Table(name = "trangthaidon_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrangThaiDon extends BaseEntity {
    @Column(name = "tentrangthai")
    private String tenTrangThai;
    @OneToMany(mappedBy = "trangThaiDon")
    @JsonManagedReference
    private Set<DonDangKy> donDangKys;
}
