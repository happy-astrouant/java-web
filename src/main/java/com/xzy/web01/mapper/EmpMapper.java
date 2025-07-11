package com.xzy.web01.mapper;

import com.xzy.web01.entity.Emp;
import com.xzy.web01.entity.EmpExpr;
import com.xzy.web01.entity.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp")
    List<Emp> getAllEmps();

    @Delete("delete from emp where id in #{ids}")
    void deleteByIds(@Param("ids") Integer[] ids);

//    @Select("select e.id, username, password, e.name, gender, phone, job, " +
//            "salary, image, entry_date, dept_id, d.name as dept_name, e.create_time, " +
//            "e.update_time from emp e left join dept d on e.dept_id = d.id order by update_time desc")
    List<Emp> getEmps(EmpQueryParam empQueryParam);

    // 原始分页查询
//    @Select("select count(*) from emp")
//    Long count();
//
//    @Select("select e.id, username, password, e.name, gender, phone, job, " +
//            "salary, image, entry_date, dept_id, d.name as dept_name, e.create_time, " +
//            "e.update_time from emp e left join dept d on e.dept_id = d.id order by update_time desc limit #{start},#{pageSize}")
//    List<Emp> getEmpsByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    // Options设置我们需要其返回主键值id，并且封装到这个类的id值
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);



}
