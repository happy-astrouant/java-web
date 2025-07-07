package com.xzy.web01.service.impl;

import com.xzy.web01.entity.Dept;
import com.xzy.web01.entity.Result;
import com.xzy.web01.mapper.DeptMapper;
import com.xzy.web01.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void insert(String name) {
        int rows = deptMapper.insert(name);

    }

    @Override
    public void updateById(Dept record) {
        int rows = deptMapper.updateById(record);

    }

    @Override
    public void deleteById(Integer id) {
        int rows = deptMapper.deleteById(id);
    }


}
