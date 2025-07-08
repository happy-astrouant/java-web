package com.xzy.web01.controller;


import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.PageResult;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result getPageEmps(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize){
        PageResult<Emp> pageResult = empService.getPageEmps(page, pageSize);
        return Result.success(pageResult);
    }

    @DeleteMapping
    public Result deleteById(Integer[] ids){
        empService.deleteById(ids);
        return Result.success();
    }

    //分页查询

}
