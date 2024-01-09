package com.example.thuctap_java.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "phattudaotrang_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhatTuDaoTrang extends BaseEntity{
    @Column(name = "dathamgia")
    private boolean daThamGia;
    @Column(name = "lydokhongthamgia")
    private String lyDoKhongThamGia;
    @Column(name = "daotrangid")
    private int daoTrangId;
    @Column(name = "phattuid")
    private int phatTuId;
    @ManyToOne
    @JoinColumn(name = "phattuid", insertable = false, updatable = false)
    @JsonBackReference
    private PhatTu phatTu;
    @ManyToOne
    @JoinColumn(name = "daotrangid", insertable = false, updatable = false)
    @JsonBackReference
    private DaoTrang daoTrang;
}
