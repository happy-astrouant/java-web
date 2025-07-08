package com.xzy.web01.mapper;

import com.xzy.web01.entity.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp")
    List<Emp> getAllEmps();

    @Delete("delete from emp where id in #{ids}")
    void deleteById(@Param("ids") Integer[] ids);

    @Select("select count(*) from emp")
    Long count();

    @Select("select e.id, username, password, e.name, gender, phone, job, " +
            "salary, image, entry_date, dept_id, d.name as dept_name, e.create_time, " +
            "e.update_time from emp e left join dept d on e.dept_id = d.id order by update_time desc limit #{start},#{pageSize}")
    List<Emp> getEmpsByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);



}
