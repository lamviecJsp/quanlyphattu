package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "refreshtoken_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseEntity{
    @Column(name = "token")
    private String toKen;
    @Column(name = "thoigianhethan")
    private LocalDate thoiGianHetHan;
    @Column(name = "phattuid")
    private int phatTuId;
    @ManyToOne
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;
}
