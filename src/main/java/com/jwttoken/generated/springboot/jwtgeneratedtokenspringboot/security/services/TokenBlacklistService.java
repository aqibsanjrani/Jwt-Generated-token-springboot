package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.services;

public interface TokenBlacklistService {

    void blacklistToken(String token);
    boolean isTokenBlacklisted(String token);
}
