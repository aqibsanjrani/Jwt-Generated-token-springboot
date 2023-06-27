package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role {
  @Id
  @GeneratedValue(generator = "r_id")
  private int r_id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  public int getR_id() {
    return r_id;
  }

  public void setR_id(int r_id) {
    this.r_id = r_id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }
}