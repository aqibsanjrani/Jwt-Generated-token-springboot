package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({TokenExpireException.class})
    public ResponseEntity<?> handleInvalidToken(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("Status", HttpStatus.BAD_REQUEST.toString());
        map.put("message","InvalidToken");

        return ResponseEntity.status(Integer.parseInt(map.get("status"))).body(map);
    }
}
