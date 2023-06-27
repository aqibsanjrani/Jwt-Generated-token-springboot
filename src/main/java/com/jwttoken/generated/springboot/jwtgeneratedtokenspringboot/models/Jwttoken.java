package com.jwttoken.generated.springboot.jwtgeneratedtokenspringboot.models;

import javax.persistence.*;

@Entity
@Table(name = "jwttoken")
public class Jwttoken {

    @Id
    @GeneratedValue(generator = "j_id")

    private long j_id;
    private String token;

    public long getJ_id() {
        return j_id;
    }

    public void setJ_id(long j_id) {
        this.j_id = j_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
