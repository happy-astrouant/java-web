package com.xzy.web01.service;

import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.PageResult;

import java.util.List;

public interface EmpService {
    List<Emp> getAllEmps();

    void deleteById(Integer[] ids);

    PageResult<Emp> getPageEmps(Integer start, Integer pageSize);
}
