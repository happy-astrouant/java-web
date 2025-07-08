package com.xzy.web01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.PageResult;
import com.xzy.web01.mapper.EmpMapper;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getAllEmps() {
        return empMapper.getAllEmps();
    }

    @Override
    public void deleteById(Integer[] ids) {
        empMapper.deleteById(ids);
    }

    @Override
    public PageResult<Emp> getPageEmps(Integer page,
                                       Integer pageSize,
                                       String name,
                                       Integer gender,
                                       LocalDate begin,
                                       LocalDate end) {
        PageResult<Emp> res = new PageResult<>();
        PageHelper.startPage(page, pageSize);
        List<Emp> emps = empMapper.getEmps();
        Page<Emp> pageInfo = (Page<Emp>) emps;
        res.setRows(pageInfo.getResult());
        res.setTotal(pageInfo.getTotal());
        return res;
    }
}
