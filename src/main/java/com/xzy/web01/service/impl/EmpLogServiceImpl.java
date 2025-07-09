package com.xzy.web01.service.impl;

import com.xzy.web01.entity.EmpLog;
import com.xzy.web01.mapper.EmpLogMapper;
import com.xzy.web01.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    EmpLogMapper empLogMapper;

    @Override
    public void insert(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
