package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "xacnhanemail_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class XacNhanEmail extends BaseEntity {
    @Column(name = "phattuid")
    private int phatTuId;
    @Column(name = "thoigianhethan")
    private LocalDate thoigianhethan;
    @Column(name = "maxacnhan")
    private String maXacNhan;
    @Column(name = "daxacnhan")
    private Boolean daXacNhan;
    @ManyToOne
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;
}
