package com.foreverything.bbs.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserRoleMapper {


    @Insert("insert into user_role(role_id,user_id) values(#{role_id},#{user_id})")
    public int insertUserRole(int user_id,int role_id);

//    @Update("update user_role set role_id = #{role_id} where")

}
