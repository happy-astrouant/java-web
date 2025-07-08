package com.xzy.web01.service;

import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    List<Emp> getAllEmps();

    void deleteById(Integer[] ids);

    PageResult<Emp> getPageEmps(Integer start, Integer pageSize,
                                String name, Integer gender,
                                LocalDate begin, LocalDate end);
}
