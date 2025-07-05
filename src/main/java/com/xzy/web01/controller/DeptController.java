package com.xzy.web01.controller;


import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    private boolean test = true;

    @Autowired
    DeptService deptService;

    @RequestMapping("/depts")
    public Result selectAllDept() {
        if(test){
            System.out.println("进入selectAllDept方法");
        }
        return deptService.selectAllDept();
    }

    @RequestMapping("/depts")
    public Result selectById(Integer id) {
        if(test){
            System.out.println("进入selectById方法");
        }
        return deptService.selectById(id);
    }

    @RequestMapping("/depts")
    public Result insert(Dept record) {
        if(test){
            System.out.println("进入insert方法");
        }
        return deptService.insert(record);
    }

    @RequestMapping("/depts")
    public Result updateById(Dept record) {
        if(test){
            System.out.println("进入updateById方法");
        }
        return deptService.updateById(record);
    }

    public Result deleteById(Integer id) {
        if(test){
            System.out.println("进入deleteById方法");
        }
        return deptService.deleteById(id);
    }
}
