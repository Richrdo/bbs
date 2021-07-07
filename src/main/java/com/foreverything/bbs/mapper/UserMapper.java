package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Author LiuJingxin
 * @Date Created in 19:23 2019/12/17
 * @Description
 */
@Mapper
public interface UserMapper {

    @Select("select password from user where email=#{email}")
    @Results({
            @Result(property = "password",column = "password"),
    })
    String getPas(@Param("email") String email);

    @Insert("insert into user(uuid,name,password,email,grade) values(#{user.uuid},#{user.name},#{user.password},#{user.email},#{user.grade})")
    public int insertUser(@Param("user") User user);

    @Select("select grade from user where email=#{email}")
    public int getPointsByEmail(@Param("email")String email);

    @Select("select is_admin from user where uuid=#{uuid}")
    public boolean isAdmin(@Param("uuid")String id);

    @Select("select uuid from user where email=#{email}")
    public String getUUIDByEmail(@Param("email")String mail);

    @Select("select * from user where email=#{email}")
    @Results({
            @Result(property = "uuid",column = "uuid"),
            @Result(property = "mail",column = "mail"),
            @Result(property = "grade",column = "grade"),
            @Result(property = "name",column = "name"),
            @Result(property = "isAdmin",column = "is_admin"),
    })
    public User getUserByEmail(String email);

    @Select("select name,uuid from user")
    @Results({
            @Result(property = "uuid",column="uuid"),
            @Result(property = "name",column = "name")
    })
    public List<User> getUserIDMap();

    @Select("select grade from user where uuid=#{uuid}")
    public int getUserPoint(@Param("uuid") String uuid);
}
