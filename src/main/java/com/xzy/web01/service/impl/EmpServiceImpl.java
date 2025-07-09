package com.xzy.web01.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xzy.web01.entity.*;
import com.xzy.web01.mapper.EmpExprMapper;
import com.xzy.web01.mapper.EmpMapper;
import com.xzy.web01.service.EmpLogService;
import com.xzy.web01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public List<Emp> getAllEmps() {
        return empMapper.getAllEmps();
    }

    @Override
    public void deleteById(Integer[] ids) {
        empMapper.deleteById(ids);
    }

    @Override
    public PageResult<Emp> getPageEmps(EmpQueryParam empQueryParam) {
        PageResult<Emp> res = new PageResult<>();
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> emps = empMapper.getEmps(empQueryParam);
        Page<Emp> pageInfo = (Page<Emp>) emps;
        res.setRows(pageInfo.getResult());
        res.setTotal(pageInfo.getTotal());
        return res;
    }

    // rollbackFor 控制出现哪些异常时，会进行回滚操作
    // 默认出现运行时异常时进行回滚
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            // 在插入时获取主键ID
            empMapper.insert(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                // 将emp的主键ID填充到empExpr中
                for(EmpExpr expr : emp.getExprList()){
                    expr.setEmpId(emp.getId());
                }
                // 批量插入
                empExprMapper.insertBatch(emp.getExprList());
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "save emp info: "+emp);
            empLogService.insert(empLog);
        }


    }
}
