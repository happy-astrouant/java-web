package com.xzy.web01.service.impl;

import com.xzy.web01.entity.Emp;
import com.xzy.web01.mapper.EmpMapper;
import com.xzy.web01.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    private EmpMapper empMapper;

    @Override
    public List<Emp> getAllEmps() {
        return empMapper.getAllEmps();
    }
}
