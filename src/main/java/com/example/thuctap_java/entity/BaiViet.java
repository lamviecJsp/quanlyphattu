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
@Table(name = "baiviet_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiViet extends BaseEntity{
    @Column(name = "loaibaivietid")
    private int loaiBaiVietId;
    @Column(name = "tieude")
    private String tieuDe;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "phattuid")
    private int phatTuId;
    @Column(name = "nguoiduyetbaivietid")
    private int nguoiDuyetBaiVietId;
    @Column(name = "soluotthich")
    private int soLuotThich;
    @Column(name = "soluotbinhluan")
    private int soLuotBinhLuan;
    @Column(name = "thoigiandang")
    private LocalDate thoiGianDang;
    @Column(name = "thoigiancapnhat")
    private LocalDate thoiGianCapNhat;
    @Column(name = "thoigianxoa")
    private LocalDate thoiGianXoa;
    @Column(name = "daxoa")
    private boolean daXoa;
    @Column(name = "trangthaibaivietid")
    private int trangThaiBaiVietId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;
    @ManyToOne
    @JoinColumn(name = "loaibaivietid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;
    @ManyToOne
    @JoinColumn(name = "trangthaibaivietid", insertable = false, updatable = false)
    @JsonBackReference
    private TrangThaiBaiViet trangThaiBaiViet;
    @OneToMany(mappedBy = "baiViet")
    @JsonManagedReference
    private Set<NguoiDungThichBaiViet> nguoiDungThichBaiViets;
    @OneToMany(mappedBy = "baiViet")
    @JsonManagedReference
    private Set<BinhLuanBaiViet> binhLuanBaiViets;

}
