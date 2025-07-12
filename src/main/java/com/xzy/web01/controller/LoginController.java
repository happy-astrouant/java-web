package com.xzy.web01.controller;


import com.xzy.web01.entity.LoginInfo;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @GetMapping("/login")
    public Result login(String username, String password) {
        LoginInfo loginInfo = empService.login(username, password);
        if(loginInfo==null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(loginInfo);
    }
}
