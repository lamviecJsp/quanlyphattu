package com.example.thuctap_java.service.impl;

import com.example.thuctap_java.dto.request.LoginRequest;
import com.example.thuctap_java.dto.request.RegisterRequest;
import com.example.thuctap_java.dto.response.MessageReponse;
import com.example.thuctap_java.dto.response.TokenResponse;
import com.example.thuctap_java.entity.Chua;
import com.example.thuctap_java.entity.PhatTu;
import com.example.thuctap_java.model.PhatTuCustomDetail;
import com.example.thuctap_java.repository.ChuaRepo;
import com.example.thuctap_java.repository.PhatTuRepo;
import com.example.thuctap_java.repository.QuyenHanRepo;
import com.example.thuctap_java.service.iservice.iAccountService;
import com.example.thuctap_java.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements iAccountService {
    @Autowired
    private PhatTuRepo phatTuRepo;

    @Autowired
    private QuyenHanRepo quyenHanRepo;

    @Autowired
    private ChuaRepo chuaRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getTenTaiKhoan(),
                loginRequest.getMatKhau()
        ));
        Optional<PhatTu> findByPhatTu= phatTuRepo.findByTenTaiKhoan(loginRequest.getTenTaiKhoan());
        if (findByPhatTu.isPresent()){
//            String jwtToken = jwtService.generatedToken(new PhatTuCustomDetail(findByPhatTu.get()));
//            return TokenResponse.builder()
//                    .toKen(jwtToken)
//                    .toKen(findByPhatTu.get().getQuyenHan().getTenQuyenHan().name())
//                    .build();
            String jwtToken = jwtService.generatedToken(new PhatTuCustomDetail(findByPhatTu.get()));
            String tenQuyenHan = findByPhatTu.get().getQuyenHan().getTenQuyenHan().name();

            TokenResponse tokenResponse = TokenResponse.builder()
                    .token(jwtToken) // Đặt mã token vào trường token của TokenResponse
                    .quyenHan(tenQuyenHan) // Đặt tên quyền hạn vào trường quyenHan của TokenResponse
                    .build();

            return tokenResponse;
        }
        return null;
    }

    @Override
    public MessageReponse register(RegisterRequest registerRequest) throws Exception {
        Optional<PhatTu> phatTuOptional= phatTuRepo.findByTenTaiKhoan(registerRequest.getTenTaiKhoan());
        if (phatTuOptional.isEmpty()){
            Optional<Chua> chuaOptional = chuaRepo.findById(registerRequest.getChuaId());
            if (chuaOptional.isEmpty()){
                throw new Exception("Không tồn tại chùa");
//            return MessageReponse.builder().mesSage("Không tồn tại chùa").build();
            }
            PhatTu phatTu = PhatTu.builder().tenTaiKhoan(registerRequest.getTenTaiKhoan())
                    .tenTaiKhoan(registerRequest.getTenTaiKhoan())
                    .matKhau(passwordEncoder.encode( registerRequest.getMatKhau()))
                    .email(registerRequest.getEmail())
                    .quyenHanId(3)
                    .build();
            phatTu.setChua(chuaOptional.get());
            phatTuRepo.save(phatTu);
            return MessageReponse.builder().mesSage("Đăng ký thành công.").build();
        } else {
            throw new Exception("User đã tồn tại");
        }

    }


}
