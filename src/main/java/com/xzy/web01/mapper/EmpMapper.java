package com.xzy.web01.mapper;

import com.xzy.web01.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp")
    List<Emp> getAllEmps();

    // 查询员工信息列表

}
