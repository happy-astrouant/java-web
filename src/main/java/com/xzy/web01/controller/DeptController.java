package com.xzy.web01.controller;


import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {

    private boolean test = true;

    @Autowired
    DeptService deptService;

    @GetMapping("/depts")
    public Result selectAllDept() {
        if(test){
            System.out.println("进入selectAllDept方法");
        }
        return deptService.selectAllDept();
    }

    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable Integer id) {
        if(test){
            System.out.println("进入selectById方法");
        }
        return deptService.selectById(id);
    }

    @PostMapping("/depts")
    public Result insert(Dept record) {
        if(test){
            System.out.println("进入insert方法");
        }
        return deptService.insert(record);
    }

    @PutMapping("/depts")
    public Result updateById(Dept record) {
        if(test){
            System.out.println("进入updateById方法");
        }
        return deptService.updateById(record);
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if(test){
            System.out.println("进入deleteById方法");
        }
        return deptService.deleteById(id);
    }
}
