package com.xzy.web01.controller;


import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping
    public Result GetAllEmps(){
        List<Emp> emps = empService.getAllEmps();
        return Result.success(emps);
    }

    @DeleteMapping
    public Result deleteById(Integer[] ids){
        empService.deleteById(ids);
        return Result.success();
    }
}
