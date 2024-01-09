package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "dondangky_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonDangKy extends BaseEntity {
    @Column(name = "ngayguidon")
    private LocalDate ngayGuiDon;
    @Column(name = "ngayxuly")
    private LocalDate ngayXuLy;
    @Column(name = "nguoixuly")
    private String nguoiXuLy;
    @Column(name = "trangthaidonid")
    private int trangThaiDonId;
    @Column(name = "daotrangid")
    private int daoTrangId;
    @Column(name = "phattuid")
    private int phatTuId;
    @Column(name = "approved")
    private boolean approved;//Kiem tra duyet don
    @ManyToOne
    @JoinColumn(name = "trangthaidonid", insertable = false, updatable = false)
    @JsonBackReference
    private TrangThaiDon trangThaiDon;
    @ManyToOne
    @JoinColumn(name = "daotrangid", insertable = false, updatable = false)
    @JsonBackReference
    private DaoTrang daoTrang;
    @ManyToOne
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean b) {
        this.approved = approved;
    }
}
