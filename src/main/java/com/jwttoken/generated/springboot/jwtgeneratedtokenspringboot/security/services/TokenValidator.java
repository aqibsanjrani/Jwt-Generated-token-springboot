package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenValidator {

    @Autowired
    private TokenBlacklistServiceImpl tokenBlacklistService;

    public boolean isTokenValid(String token) {
        return !tokenBlacklistService.isTokenBlacklisted(token);
    }

}

