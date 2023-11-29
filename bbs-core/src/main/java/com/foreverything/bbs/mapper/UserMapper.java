package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.entities.User_old;
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
    @Insert("insert into user(email,name,password) values(#{email},#{name},#{password})")
    public int insertUser(String email,String name,String password);

    @Select("select points from user where email=#{email}")
    public int getPointsByEmail(@Param("email")String email);

    @Select("select points from user where id=#{id}")
    public int getPointsById(int id);

    @Select("SELECT LAST_INSERT_ID()")
    public int getInsertedUserId();

    @Select("select * from user where email=#{email}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "points",column = "points"),
            @Result(property = "name",column = "name")
    })
    public User getUserByEmail(String email);

}
