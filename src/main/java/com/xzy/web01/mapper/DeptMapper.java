package com.xzy.web01.mapper;

import org.apache.ibatis.annotations.*;
import com.xzy.web01.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 获取所有部门信息，按修改时间倒序排序
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> selectAllDept();

    @Update("update dept set name=#{name},location=#{location} where id=#{id}")
    int updateById(Dept record);

    @Insert("insert into dept(name,create_time, update_time) values(#{name}, #{create_time},#{update_time})")
    int insert(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept selectById(Integer id);

    @Delete("delete from dept where id=#{id}")
    int deleteById(Integer id);
}
