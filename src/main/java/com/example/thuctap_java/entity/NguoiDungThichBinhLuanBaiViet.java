package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "nguoidungthichbinhluanbaiviet_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDungThichBinhLuanBaiViet extends BaseEntity{
    @Column(name = "phattuid")
    private int phatTuId;
    @Column(name = "binhluanbaivietid")
    private int binhLuanBaiVietId;
    @Column(name = "thoigianthich")
    private LocalDate thoiGianThich;
    @Column(name = "daxoa")
    private Boolean daXoa;
    @ManyToOne
    @JoinColumn(name = "binhluanbaivietid", insertable = false, updatable = false)
    @JsonBackReference
    private BinhLuanBaiViet binhLuanBaiViet;
    @ManyToOne
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;
}
