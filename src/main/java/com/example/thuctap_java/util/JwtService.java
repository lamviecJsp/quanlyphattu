package com.example.thuctap_java.util;

import com.example.thuctap_java.model.PhatTuCustomDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="955076cc7ee512a55ca8d78848cf3af9bd26ae093fd33e7081c933bd7ac98490";
    public String extractTenTaiKhoan(String token) {
        return extractClass(token,Claims::getSubject);
    }
    public <T> T extractClass(String token, Function<Claims,T> claimsTFunction){
        final Claims claims= extractAllClaims(token);
        return claimsTFunction.apply(claims) ;
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignInkey()).build().parseClaimsJws(token).getBody();
    }
    public String generatedToken( PhatTuCustomDetail phatTuCustomDetail){
        return generatedToken(new HashMap<>(),phatTuCustomDetail);
    }
    public String generatedToken(Map<String,Object> extractClam, PhatTuCustomDetail phatTuCustomDetail){
            return buildToken(extractClam, phatTuCustomDetail);
    }

    public String buildToken(Map<String,Object> extractClam, PhatTuCustomDetail phatTuCustomDetail){
        String compact = Jwts.builder().setClaims(extractClam).setSubject(phatTuCustomDetail.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)).signWith(getSignInkey(), SignatureAlgorithm.HS256).compact();
        return compact;

    }

    public boolean istokenValid(String token, UserDetails phatTuDetails){
        final String tenPhatTu= extractTenTaiKhoan(token);
        return (tenPhatTu.equals(phatTuDetails.getUsername()))&& !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration (String token){
        return extractClass(token,Claims::getExpiration);
    }
    public Key getSignInkey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
