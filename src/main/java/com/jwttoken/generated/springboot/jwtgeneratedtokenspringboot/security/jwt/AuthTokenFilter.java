package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.jwt;

import java.io.IOException;
import java.security.SignatureException;

import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.services.TokenBlacklistServiceImpl;
import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.security.services.UserDetailsServiceImpl;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private TokenBlacklistServiceImpl tokenBlacklistService;

  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {


    //try {
      String jwt = parseJwt(request);

      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
        String username = jwtUtils.getUserNameFromJwtToken(jwt);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }

      String token = extractToken(request);

      if (token != null) {
        // Check if the token is blacklisted
        if (tokenBlacklistService.isTokenBlacklisted(token)) {

          response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is expired");
          throw new TokenExpireException("Invalid or expired token!");

        }
      }

  //  } catch (Exception e) {
  //    logger.error("Cannot set user authentication: {}", e);
   // }

    filterChain.doFilter(request, response);
  }

  private String parseJwt(HttpServletRequest request) {
    String headerAuth = request.getHeader("Authorization");

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      return headerAuth.substring(7);
    }

    return null;
  }

  private String extractToken(HttpServletRequest request) {

    String header = request.getHeader("Authorization");
    if (header != null && header.startsWith("Bearer ")) {
      return header.substring(7); // Extract the token after "Bearer "
    }
    return null;
  }


}
