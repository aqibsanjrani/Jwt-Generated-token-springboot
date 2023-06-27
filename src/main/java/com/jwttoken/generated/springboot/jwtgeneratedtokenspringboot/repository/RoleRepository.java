package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.repository;

import java.util.Optional;

import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models.ERole;
import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
