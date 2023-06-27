package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.repository;

import com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models.Jwttoken;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwttoketRepository extends JpaRepository<Jwttoken , Long > {
}
