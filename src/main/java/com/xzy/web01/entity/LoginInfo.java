package com.xzy.web01.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {

    private Integer id;
    private String username;
    private String name;
    private String token;
}
