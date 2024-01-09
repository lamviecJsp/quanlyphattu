package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

import javax.net.ssl.SSLSession;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "phattu_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@QuerydslPredicate
public class PhatTu extends BaseEntity{
    @Column(name = "tentaikhoan")
    private String tenTaiKhoan;
    @Column(name = "anhchup")
    private String anhChup;
    @Column(name = "doahoantuc")
    private boolean daHoanTuc;
    @Column(name = "email")
    private String email;
    @Column(name = "gioitinh")
    private String gioiTinh;
    @Column(name = "ngaycapnhat")
    private LocalDate ngayCapNhat;
    @Column(name = "ngayhoantuc")
    private LocalDate ngayHoanTuc;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "matkhau")
    private String matKhau;
    @Column(name = "phapdanh")
    private String phapDanh;
    @Column(name = "sodienthoai")
    private String soDienDhoai;
    @Column(name = "quyenhanid")
    private int quyenHanId;
    @ManyToOne
    @JoinColumn(name = "chuaid", insertable = true, updatable = true)
    @JsonBackReference
    private Chua chua;
    @ManyToOne
    @JoinColumn(name = "quyenhanid", insertable = false, updatable = false)
    @JsonBackReference
    private QuyenHan quyenHan;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<DonDangKy> donDangKys;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<PhatTuDaoTrang> phatTuDaoTrangs;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<RefreshToken> refreshTokens;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<BaiViet> baiViets;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<NguoiDungThichBaiViet> nguoiDungThichBaiViets;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<XacNhanEmail> xacNhanEmails;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<BinhLuanBaiViet> binhLuanBaiViets;
    @OneToMany(mappedBy = "phatTu")
    @JsonManagedReference
    private Set<NguoiDungThichBinhLuanBaiViet> nguoiDungThichBinhLuanBaiViets;


}
