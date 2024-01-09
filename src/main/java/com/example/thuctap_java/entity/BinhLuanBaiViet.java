package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "binhluanbaiviet_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BinhLuanBaiViet extends BaseEntity {
    @Column(name = "baivietid")
    private int baiVietId;
    @Column(name = "phattuid")
    private int phatTuId;
    @Column(name = "binhluan")
    private String binhLuan;
    @Column(name = "soluotthich")
    private int soLuotThich;
    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao;
    @Column(name = "thoigiancapnhat")
    private LocalDate thoiGianCapNhat;
    @Column(name = "thoigianxoa")
    private LocalDate thoiGianXoa;
    @Column(name = "daxoa")
    private boolean daXoa;
    @ManyToOne
    @JoinColumn(name = "baivietid", insertable = false, updatable = false)
    @JsonBackReference
    private BaiViet baiViet;
    @ManyToOne
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;
    @OneToMany(mappedBy = "binhLuanBaiViet")
    @JsonManagedReference
    private Set<NguoiDungThichBinhLuanBaiViet> nguoiDungThichBinhLuanBaiViets;

}
