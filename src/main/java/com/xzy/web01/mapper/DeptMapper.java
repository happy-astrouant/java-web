package com.xzy.web01.mapper;

import org.apache.ibatis.annotations.*;
import com.xzy.web01.entity.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 获取所有部门信息，按修改时间倒序排序
    @Select("select id, name, create_name, update_name from dept order by update_name desc")
    List<Dept> selectAllDept();

    @Update("update dept set name=#{name},location=#{location} where id=#{id}")
    int updateById(Dept record);

    @Insert("insert into dept(name,location) values(#{name},#{location})")
    int insert(Dept record);

    @Select("select id, name, create_name, update_name from dept where id=#{id}")
    Dept selectById(Integer id);

    @Delete("delete from dept where id=#{id}")
    int deleteById(Integer id);
}
