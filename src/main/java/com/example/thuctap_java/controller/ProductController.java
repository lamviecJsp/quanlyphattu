package com.example.thuctap_java.controller;

import com.example.thuctap_java.dto.DTO.*;
import com.example.thuctap_java.dto.request.*;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.entity.BaiViet;
import com.example.thuctap_java.entity.BinhLuanBaiViet;
import com.example.thuctap_java.entity.DonDangKy;
import com.example.thuctap_java.entity.PhatTu;
import com.example.thuctap_java.service.sevices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@RequestMapping(value = "/api/auth/")
@RestController
@ControllerAdvice
public class ProductController {
    @Autowired
    private final PhatTuService phatTuService;
    @Autowired
    private final DaoTrangService daoTrangService;
    @Autowired
    private final ChuaService chuaService;
    @Autowired
    private final TrangThaiDonService trangThaiDonService;
    @Autowired
    private final DonDangKyService donDangKyService;
    @Autowired
    private final BaiVietService baiVietService;
    @Autowired
    private final BinhLuanBaiVietService binhLuanBaiVietService;
    @Autowired
    private final NguoiDungThichBaiVietService nguoiDungThichBaiVietService;
    @Autowired
    private final NguoiDungThichBinhLuanService nguoiDungThichBinhLuanService;
    @Autowired
    private final LoaiBaiVietService loaiBaiVietService;
    @Autowired
    private final TrangThaiBaiVietSevice trangThaiBaiVietSevice;
    public ProductController(PhatTuService phatTuService, DaoTrangService daoTrangService, ChuaService chuaService, TrangThaiDonService trangThaiDonService, DonDangKyService donDangKyService, BaiVietService baiVietService, BinhLuanBaiVietService binhLuanBaiVietService, NguoiDungThichBaiVietService nguoiDungThichBaiVietService, NguoiDungThichBinhLuanService nguoiDungThichBinhLuanService, LoaiBaiVietService loaiBaiVietService, TrangThaiBaiVietSevice trangThaiBaiVietSevice) {
        this.phatTuService = phatTuService;
        this.daoTrangService = daoTrangService;
        this.chuaService = chuaService;
        this.trangThaiDonService = trangThaiDonService;
        this.donDangKyService = donDangKyService;
        this.baiVietService = baiVietService;
        this.binhLuanBaiVietService = binhLuanBaiVietService;
        this.nguoiDungThichBaiVietService = nguoiDungThichBaiVietService;
        this.nguoiDungThichBinhLuanService = nguoiDungThichBinhLuanService;
        this.loaiBaiVietService = loaiBaiVietService;
        this.trangThaiBaiVietSevice = trangThaiBaiVietSevice;
    }

    //ChuaController
    @PostMapping(value = "themchua", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChuaDTO> themChua(@RequestBody ThemChuaRequest request) {
        return chuaService.themChua(request);
    }

    //PhatTuController
    @GetMapping(value = "Locvaphantrang", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PhatTu> findByTenTaiKhoanContainingAndEmailContainingAndGioiTinh(@RequestParam String ten,@RequestParam String email,@RequestParam String gioiTinh,@RequestParam int PageSize,@RequestParam int PageNumber){
        return phatTuService.findByTenTaiKhoanContainingAndEmailContainingAndGioiTinh(ten, email, gioiTinh, PageSize, PageNumber);
    }

    //TrangThaiDonController
    @PostMapping(value = "themttd", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TrangThaiDonDTO> themTrangThaiDon(@RequestBody ThemTrangThaiDonRequest request) {
        return trangThaiDonService.themTrangThaiDon(request);
    }

    //DonDangKyController
    @PostMapping(value = "themddk", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<DonDanKyDTO> themDonDangKy(@RequestBody ThemDonDangKyRequest request){
        return donDangKyService.themDonDangKy(request);
    }

    @PutMapping(value = "suaddk", produces = MediaType.APPLICATION_JSON_VALUE)
    public String suaDonDangKy(@RequestParam int donDangKyId,@RequestBody SuaDonDangKyRequest request) {
        return donDangKyService.suaDonDangKy(donDangKyId, request);
    }

    @DeleteMapping(value = "xoaddk", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaDonDangKy(@RequestParam int donDangKyId){
        return donDangKyService.xoaDonDangKy(donDangKyId);
    }



    @GetMapping(value = "timkiemddk", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DonDangKy> timkiem(@RequestParam String nguoiXuLy) {
        return donDangKyService.timkiem(nguoiXuLy);
    }

    @GetMapping(value = "phantrangddk", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<DonDanKyDTO> phantrang(@RequestParam int PageSize,@RequestParam int PageNumber) {
        return donDangKyService.phantrang(PageSize, PageNumber);
    }

    //DaoTrangController
    @PostMapping(value = "thamgiadaotrang", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<DaoTrangDT0> themDaoTrang(@RequestBody ThemDaoTrangRequest request) {
        return daoTrangService.themDaoTrang(request);
    }

    @PutMapping(value = "suadaotrang", produces = MediaType.APPLICATION_JSON_VALUE)
    public String SuaDaoTrang(@RequestParam int daoTrangId, @RequestBody SuaDaoTrangRequest request) {
        return daoTrangService.SuaDaoTrang(daoTrangId,request);
    }

    @DeleteMapping(value = "xoadaotrang", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaDaoTrang(@RequestParam int daoTrangId) {
        return daoTrangService.xoaDaoTrang(daoTrangId);
    }

    @GetMapping(value = "tkvaPt", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<DaoTrangDT0> searchDaoTrang(@RequestParam LocalDate khoangThoiGian,@RequestParam String chuTri,@RequestParam int PageSize,@RequestParam int PageNumber){
        return daoTrangService.searchDaoTrang(khoangThoiGian, chuTri, PageSize, PageNumber);
    }

    //BaiVietController
    @PostMapping(value = "thembaiviet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<BaiVietDTO> taoBaiViet(@RequestBody ThemBaiVietRequest request) {
        return baiVietService.taoBaiViet(request);
    }

    @DeleteMapping(value = "xoabaiviet", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaBaiViet(@RequestParam int baiVietId){
       return baiVietService.xoaBaiViet(baiVietId);
    }

    //LoaiBaiVietController
    @PostMapping(value = "themlbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiBaiVietDTO> themLoaiBaiViet(@RequestBody ThemLoaiBaiVietRequest request){
        return loaiBaiVietService.themLoaiBaiViet(request);
    }

    @PutMapping(value = "sualbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public String suaLoaiBaiViet(@RequestParam int loaiBaiVietId,@RequestBody SuaLoaiBaiVietRequest request) {
        return loaiBaiVietService.suaLoaiBaiViet(loaiBaiVietId, request);
    }

    @DeleteMapping(value = "xoalbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaLoaiBaiViet(@RequestParam int loaiBaiVietId){
        return loaiBaiVietService.xoaLoaiBaiViet(loaiBaiVietId);
    }




    //BinhLuanBaiVietController
    @PostMapping(value = "themblbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public BinhLuanBaiViet createBinhLuan(@RequestBody BinhLuanBaiViet binhLuan) {
        return binhLuanBaiVietService.createBinhLuan(binhLuan);
    }

    @DeleteMapping(value = "xoablbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBinhLuanById(@RequestParam int binhLuanId,@RequestParam int baiVietId){
        binhLuanBaiVietService.deleteBinhLuanById(binhLuanId, baiVietId);
    }

    //NguoiDungThichBaiVietController
    @PostMapping(value = "likebv", produces = MediaType.APPLICATION_JSON_VALUE)
    public void likeBaiViet(@RequestParam int phatTuId,@RequestParam int baiVietId) {
        nguoiDungThichBaiVietService.likeBaiViet(phatTuId, baiVietId);
    }

    @DeleteMapping(value = "unlikebv", produces = MediaType.APPLICATION_JSON_VALUE)
    public void unlikeBaiViet(@RequestParam int phatTuId,@RequestParam int baiVietId){
        nguoiDungThichBaiVietService.unlikeBaiViet(phatTuId, baiVietId);
    }

    //NguoiDungThichBinhLuanBaiVietController
    @PostMapping(value = "likeblbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public void likeBinhLuan(@RequestParam int phatTuId, @RequestParam int binhLuanBaiVietId) {
        nguoiDungThichBinhLuanService.likeBinhLuan(phatTuId, binhLuanBaiVietId);
    }

    @DeleteMapping(value = "unlikenlbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public void unlikeBinhLuan(@RequestParam int phatTuId,@RequestParam int binhLuanBaiVietId){
        nguoiDungThichBinhLuanService.unlikeBinhLuan(phatTuId, binhLuanBaiVietId);
    }

    //TrangThaiBaiVietController
    @PostMapping(value = "themttbv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TrangThaiBaiVietDTO> themTrangThaiBaiViet(@RequestBody ThemTrangThaiBaiVietRequest request) {
        return trangThaiBaiVietSevice.themTrangThaiBaiViet(request);
    }

    @GetMapping(value = "admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String admin(){
        return "Đây là quản trị viên";
    }
    @GetMapping(value = "manager", produces = MediaType.APPLICATION_JSON_VALUE)
    public String manager(){
        return "Đây là người điều hành";
    }
    @GetMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
    public String user(){
        return "Đây là ngưừi dùng";
    }
}
