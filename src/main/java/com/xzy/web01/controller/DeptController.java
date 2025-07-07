package com.xzy.web01.controller;


import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    DeptService deptService;

    @GetMapping
    public Result selectAllDept() {
        log.debug("enter method selectALlDept");
        return Result.success(deptService.selectAllDept());
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        log.debug("enter method selectById");
        return Result.success(deptService.selectById(id));
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.debug("enter method insert");
        deptService.insert(dept);
        return Result.success();
    }

    @PutMapping
    public Result updateById(@RequestBody Dept record) {
        log.debug("enter method updateById");
        deptService.updateById(record);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteById(Integer id) {
        log.debug("enter method deleteById");
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
