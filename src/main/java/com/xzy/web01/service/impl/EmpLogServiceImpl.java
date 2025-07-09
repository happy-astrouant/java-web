package com.xzy.web01.service.impl;

import com.xzy.web01.entity.EmpLog;
import com.xzy.web01.mapper.EmpLogMapper;
import com.xzy.web01.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    EmpLogMapper empLogMapper;

    // 默认属性为REQUIRED，即自动与上级事务合并，设置为REQUIRES_NEW，单独创建事务
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
