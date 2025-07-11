package com.xzy.web01.service;

import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.EmpQueryParam;
import com.xzy.web01.entity.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    List<Emp> getAllEmps();

    void deleteByIds(Integer[] ids);

    void deleteByIds(List<Integer> ids);

    PageResult<Emp> getPageEmps(EmpQueryParam empQueryParam);

    void save(Emp emp);

}
