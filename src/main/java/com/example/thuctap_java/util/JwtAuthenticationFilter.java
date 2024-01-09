package com.example.thuctap_java.util;

import com.example.thuctap_java.model.PhatTuCustomDetail;
import com.example.thuctap_java.service.impl.PhatTuDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authen = request.getHeader("Authorization");
        final String jwt;
        final String username;
        if(authen == null || !authen.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authen.substring(7);

        username = jwtService.extractTenTaiKhoan(jwt);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            PhatTuCustomDetail userCustomDetail = (PhatTuCustomDetail) this.userDetailsService.loadUserByUsername(username);
            if(jwtService.istokenValid(jwt, userCustomDetail)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userCustomDetail, null, userCustomDetail.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
