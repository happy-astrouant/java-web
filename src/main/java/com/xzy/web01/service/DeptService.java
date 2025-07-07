package com.xzy.web01.service;


import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {

    public List<Dept> selectAllDept();

    public Dept selectById(Integer id);

    public void insert(String name);

    public void updateById(Dept record);

    public void deleteById(Integer id);
}
