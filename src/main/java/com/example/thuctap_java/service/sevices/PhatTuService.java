package com.example.thuctap_java.service.sevices;

import com.example.thuctap_java.Converter.PhatTuConverter;
import com.example.thuctap_java.dto.DTO.PhatTuDTO;
import com.example.thuctap_java.entity.PhatTu;
import com.example.thuctap_java.repository.PhatTuRepo;
import com.example.thuctap_java.service.iservice.iPhatTuService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class PhatTuService implements iPhatTuService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PhatTuRepo phatTuRepo;
    @Autowired
    private PhatTuConverter phatTuConverter;

    @Override
    public Page<PhatTu> findByTenTaiKhoanContainingAndEmailContainingAndGioiTinh(String tenTaiKhoan, String email, String gioiTinh, int PageSize, int PageNumber) {
        PageRequest pageRequest = PageRequest.of(PageNumber-1,PageSize);
        return phatTuRepo.findByTenTaiKhoanContainingAndEmailContainingAndGioiTinh(tenTaiKhoan, email, gioiTinh, pageRequest);

    }
}
