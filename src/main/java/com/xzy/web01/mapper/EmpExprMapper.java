package com.xzy.web01.mapper;


import com.xzy.web01.entity.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);

    @Delete("delete from emp_expr where emp_id = #{empId}")
    void deleteByEmpId(Integer empId);
}
