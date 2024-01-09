package com.example.thuctap_java.service.iservice;

import com.example.thuctap_java.entity.BinhLuanBaiViet;

public interface iBinhLuanBaiVietService {
    public BinhLuanBaiViet createBinhLuan(BinhLuanBaiViet binhLuan);
    public void deleteBinhLuanById(int binhLuanId, int baiVietId);


}
