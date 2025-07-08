package com.xzy.web01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private Integer deptId;

    private String name;
    private String username;
    private String password;
    private Integer gender;
    private String phone;
    private Integer job;
    private Integer salary;
    private String image;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 需要根据ID从Dept表中查询部门名称
    private String deptName;

    // 工作经历信息，名称应当与前端传递的参数名保持一致
    private List<EmpExpr> exprList;
}
