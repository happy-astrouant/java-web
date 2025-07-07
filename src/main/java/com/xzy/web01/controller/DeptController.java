package com.xzy.web01.controller;


import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {

    private final boolean test = true;

    @Autowired
    DeptService deptService;

    @GetMapping("/depts")
    public Result selectAllDept() {
        if(test){
            System.out.println("进入selectAllDept方法");
        }
        return Result.success(deptService.selectAllDept());
    }

    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable Integer id) {
        if(test){
            System.out.println("进入selectById方法");
        }
        return Result.success(deptService.selectById(id));
    }

    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept) {
        if(test){
            System.out.println("进入insert方法");
        }
        deptService.insert(dept);
        return Result.success();
    }

    @PutMapping("/depts")
    public Result updateById(Dept record) {
        if(test){
            System.out.println("进入updateById方法");
        }
        deptService.updateById(record);
        return Result.success();
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if(test){
            System.out.println("进入deleteById方法");
        }
        deptService.deleteById(id);
        return Result.success();
    }



    // 不推荐
//    @DeleteMapping("/depts")
//    public Result deleteById(HttpServletRequest request){
//        String idStr = request.getParameter("id");
//        Integer id = Integer.getInteger(idStr);
//        return deptService.deleteById(id);
//    }

    /*这里也可以使用@RequestParam进行获取，如果不是必要的参数，可以设置false*/
//    @DeleteMapping("/depts")
//    public Result deleteById(@RequestParam(value="id", required=false) Integer id){
//        return deptService.deleteById(id);
//    }
}
