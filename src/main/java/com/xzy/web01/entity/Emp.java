package com.xzy.web01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private Integer deptId;
    private String name;
    private String username;
    private String password;
    private Integer sex;
    private String phone;
    private Integer job;
    private Integer salary;
    private String image;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
