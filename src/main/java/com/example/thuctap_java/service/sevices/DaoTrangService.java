package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.DaoTrangConverter;
import com.example.thuctap_java.dto.DTO.DaoTrangDT0;
import com.example.thuctap_java.dto.request.SuaDaoTrangRequest;
import com.example.thuctap_java.dto.request.ThemDaoTrangRequest;
import com.example.thuctap_java.dto.response.ResponseObject;
import com.example.thuctap_java.entity.DaoTrang;
import com.example.thuctap_java.repository.DaoTrangRepo;
import com.example.thuctap_java.service.iservice.iDaoTrangService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DaoTrangService implements iDaoTrangService {
    @Autowired
    private DaoTrangRepo daoTrangRepo;
    @Autowired
    private DaoTrangConverter daoTrangConverter;
    @Autowired
    private EntityManager entityManager;
    private ResponseObject<DaoTrangDT0> DaoTrangDT0ResponseObject;

    public DaoTrangService() {
        DaoTrangDT0ResponseObject = new ResponseObject<DaoTrangDT0>();
    }

    @Override
    public ResponseObject<DaoTrangDT0> themDaoTrang(ThemDaoTrangRequest request) {
        var themdaotrang = daoTrangConverter.themDaoTrang(request);
        daoTrangRepo.save(themdaotrang);
        return DaoTrangDT0ResponseObject.responseSuccess("Thêm đạo tràng thành công", daoTrangConverter.entityToDTO(themdaotrang));
    }

    @Override
    public String SuaDaoTrang(int daoTrangId, SuaDaoTrangRequest request) {
        var daoTrang = daoTrangRepo.findAll().stream().filter(x -> x.getId() == daoTrangId).findFirst();
        if (daoTrang.isEmpty()) {
            return "Đạo tràng không tồn tại";
        }
        var suaDaoTrang = daoTrangConverter.suaDaoTrang(daoTrang.get(), request);
        daoTrangRepo.save(suaDaoTrang);
        return "Sửa thành công ";
    }

    @Override
    public String xoaDaoTrang(int daoTrangId) {
        var daoTrang = daoTrangRepo.findAll().stream().filter(x -> x.getId() == daoTrangId).findFirst();
        if (daoTrang.isEmpty()) {
            return "Đạo tràng không tồn tại";
        }
        daoTrangRepo.delete(daoTrang.get());
        return "Xoá thành công";
    }

    @Override
    public Set<DaoTrangDT0> searchDaoTrang(LocalDate khoangThoiGian, String chuTri, int PageSize, int PageNumber) {
        // Tạo builder cho query
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DaoTrang> query = builder.createQuery(DaoTrang.class);
        Root<DaoTrang> root = query.from(DaoTrang.class);
        // Xây dựng predicate: Filter các điều kiện tìm kiếm
        Predicate predicate = builder.conjunction();
        if (chuTri != null && !chuTri.isEmpty()) {
            predicate = builder.and(predicate, builder.like(root.get("chuTri"), "%"+chuTri+"%"));
        }
        if (khoangThoiGian != null ) {
            predicate = builder.and(predicate, builder.equal(root.get("khoangThoiGian"), khoangThoiGian));
        }
        // Set predicate for query
        query.where(predicate);

        return daoTrangRepo.findAll().stream().skip((PageNumber - 1) * PageSize).limit(PageSize).map(x ->daoTrangConverter.entityToDTO(x)).collect(Collectors.toSet());
    }
}
