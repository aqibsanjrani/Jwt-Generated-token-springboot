package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.controllers;
import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models.Jwttoken;
import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.repository.JwttoketRepository;
import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.services.TokenBlacklistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class SignOutController {

    @Autowired
    private TokenBlacklistServiceImpl tokenBlacklistService;
    @Autowired
    private JwttoketRepository jwttoketRepository;

    @PostMapping("/sign-out")
    public ResponseEntity<String> signOut(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); // Remove "Bearer " prefix

        tokenBlacklistService.blacklistToken(token);
        Jwttoken jwttoken = new Jwttoken();
        jwttoken.setToken(token);
        jwttoketRepository.save(jwttoken);

        return ResponseEntity.ok("Token Sign-out successfully");
    }
}
