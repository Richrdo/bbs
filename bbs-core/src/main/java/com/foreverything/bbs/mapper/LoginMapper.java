package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Role;
import com.foreverything.bbs.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {

    @Select("select * from user where email = #{email}")
    User loadUserByUserEmail(String email);

    @Select("select * from role where role.id in (select role_id from user_role where user_id = #{id})")
    List<Role> findRoleByUserId(int id);
}
