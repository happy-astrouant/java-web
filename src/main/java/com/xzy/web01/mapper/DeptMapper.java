package com.xzy.web01.mapper;

import org.apache.ibatis.annotations.*;
import com.xzy.web01.entity.Dept;

@Mapper
public interface DeptMapper {

    @Update("update dept set name=#{name},location=#{location} where id=#{id}")
    int updateByPrimaryKey(Dept record);

    @Insert("insert into dept(name,location) values(#{name},#{location})")
    int insert(Dept record);

    @Select("select id, name, create_name, update_name from dept where id=#{id}")
    Dept selectByPrimaryKey(Integer id);

    @Delete("delete from dept where id=#{id}")
    int deleteByPrimaryKey(Integer id);
}
