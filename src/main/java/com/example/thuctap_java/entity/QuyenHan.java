package com.example.thuctap_java.entity;

import com.example.thuctap_java.enumeration.RoleEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "quyenhan_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuyenHan extends BaseEntity{
    @Column(name = "tenquyenhan")
    private RoleEnum tenQuyenHan;
    @OneToMany(mappedBy = "quyenHan",fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<PhatTu> phatTus;
}
