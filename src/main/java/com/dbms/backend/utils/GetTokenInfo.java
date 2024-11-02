package com.dbms.backend.utils;

import org.springframework.stereotype.Component;

import com.dbms.backend.config.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetTokenInfo{
    final JwtService jwtService;

    public String getId(HttpServletRequest request){
      final String authHeader = request.getHeader("Authorization");
      final String jwt = authHeader.substring(7);
      String id = jwtService.extractId(jwt);
      return id; 
    }
}
