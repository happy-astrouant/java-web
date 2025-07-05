package com.xzy.web01.service;


import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import org.springframework.stereotype.Service;


public interface DeptService {

    public Result selectAllDept();

    public Result selectById(Integer id);

    public Result insert(Dept record);

    public Result updateById(Dept record);

    public Result deleteById(Integer id);
}
