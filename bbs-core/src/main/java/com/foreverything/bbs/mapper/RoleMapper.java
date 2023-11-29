package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select id,type,name from role where id in (select role_id from user_role where user_id = #{id})")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "type",column = "type"),
            @Result(property = "name",column = "name")
    })
    public List<Role> queryUserRoleList(int id);

}
