package com.smithwang.demoproject1.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {

    private Integer id;

    private String name;


    private String token;

//    @JsonIgnore
    private String password;


    public User(){}

    public User(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
