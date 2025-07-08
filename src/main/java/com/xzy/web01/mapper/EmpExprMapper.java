package com.xzy.web01.mapper;


import com.xzy.web01.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void addBatch(List<EmpExpr> exprList);
}
