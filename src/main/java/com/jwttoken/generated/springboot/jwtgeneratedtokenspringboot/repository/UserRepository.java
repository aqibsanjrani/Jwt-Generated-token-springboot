package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.repository;

import java.util.Optional;

import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);


  }
