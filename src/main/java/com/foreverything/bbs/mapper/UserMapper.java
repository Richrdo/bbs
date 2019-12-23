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

    @Select("select u_password from user where u_id=#{id}")
    @Results({
            @Result(property = "password",column = "u_password",id = true),
    })
    String getPas(@Param("id") int id);

    @Insert("insert into user(u_id,u_name,u_password,u_mail,u_grade) values(#{user.id},#{user.name},#{user.password},#{user.mail},#{user.grade})")
    public int insertUser(@Param("user") User user);

    @Select("select u_id from user")
    public List<Integer> getUserIdCollection();

    @Select("select u_grade from user where u_id=#{id}")
    public int getPointsByID(@Param("id")int id);

    @Select("select u_is_admin from user where u_id=#{id}")
    public boolean isAdmin(@Param("id")int id);

    @Select("select u_id from user where u_mail=#{mail}")
    public int getIDByEmail(@Param("mail")String mail);

    @Select("select * from user where u_id=#{id}")
    @Results({
            @Result(property = "id",column = "u_id"),
            @Result(property = "mail",column = "u_mail"),
            @Result(property = "grade",column = "u_grade"),
            @Result(property = "name",column = "u_name"),
            @Result(property = "isAdmin",column = "u_is_admin"),
    })
    public User getUserByID(int id);

    @Select("select u_name,u_id from user")
    @Results({
            @Result(property = "id",column="u_id"),
            @Result(property = "name",column = "u_name")
    })
    public List<User> getUserIDMap();

    @Select("select u_grade from user where u_id=#{id}")
    public int getUserPoint(@Param("id") int id);
}
