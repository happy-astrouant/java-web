package com.xzy.web01.controller;


import com.xzy.web01.entity.LoginInfo;
import com.xzy.web01.entity.Result;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> param) {
        String username = (String) param.get("username");
        String password = (String) param.get("password");
        LoginInfo loginInfo = empService.login(username, password);
        if(loginInfo==null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(loginInfo);
    }
}
