package com.xzy.web01.controller;


import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.EmpQueryParam;
import com.xzy.web01.entity.PageResult;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    EmpService empService;

//    @GetMapping
//    public Result GetAllEmps(){
//        List<Emp> emps = empService.getAllEmps();
//        return Result.success(emps);
//    }

    @GetMapping
    public Result getPageEmps(EmpQueryParam empQueryParam){
        PageResult<Emp> pageResult = empService.getPageEmps(empQueryParam);
        return Result.success(pageResult);
    }

    // 新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }


//    @DeleteMapping
//    public Result deleteByIds( Integer[] ids){
//        empService.deleteByIds(ids);
//        return Result.success();
//    }


    // 删除员工，并且删除对应的工作经理
    // 如果将附加参数封装到集合中，必须加上@RequestParam注解
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Integer> ids){
        empService.deleteByIds(ids);
        return Result.success();
    }

}
