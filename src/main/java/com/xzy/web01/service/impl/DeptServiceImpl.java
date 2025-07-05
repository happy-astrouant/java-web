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
    public Result selectAllDept() {
        List<Dept> deptList = deptMapper.selectAllDept();
        return deptList == null ? Result.error() : Result.success(deptList);
    }

    @Override
    public Result selectById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept == null ? Result.error() : Result.success(dept);
    }

    @Override
    public Result insert(Dept record) {
        int rows = deptMapper.insert(record);
        return rows > 0 ? Result.error() : Result.success();
    }

    @Override
    public Result updateById(Dept record) {
        int rows = deptMapper.updateById(record);
        return rows > 0 ? Result.error() : Result.success();
    }

    @Override
    public Result deleteById(Integer id) {
        int rows = deptMapper.deleteById(id);
        return rows > 0 ? Result.error() : Result.success();
    }


}
