package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.services;

import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models.Jwttoken;
import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.repository.JwttoketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TokenBlacklistServiceImpl implements TokenBlacklistService {

    private Set<String> blacklistedTokens = new HashSet<>();

    @Autowired
    public TokenBlacklistServiceImpl(JwttoketRepository repository){
        List<Jwttoken> list = repository.findAll();
        if(list != null && list.size() > 0)
        blacklistedTokens = list.stream().map(e->e.getToken()).collect(Collectors.toSet());
    }

    @Override
    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }

    @Override
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

}

