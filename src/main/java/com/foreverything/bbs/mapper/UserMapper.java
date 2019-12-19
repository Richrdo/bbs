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
    @Select("select u_id from user")
    @Results({
            @Result(property = "userID",column = "u_id",id = true),
    })
    List<Integer> getID();

    @Select("select u_password from user where u_id=#{id}")
    @Results({
            @Result(property = "password",column = "u_password",id = true),
    })
    String getPas(@Param("id") int id);


    @Insert("insert into user(u_id,u_account,u_password,u_mail,u_grade) values(#{user.userID},#{user.account},#{user.password},#{user.mail},#{user.grade})")
    public int insertUser(@Param("user") User user);

    @Select("select u_id from user")
    public List<Integer> getUserIdCollection();

    //修改账户名
    @Update("update user set u_account=#{new_account} where u_id=#{id}")
    boolean updateAcc(@Param("id") int id,@Param("new_account") String new_account);

    //更新密码
    @Update("update user set u_password=#{newpassword} where u_id=#{id}")
    boolean updatePas(@Param("id") int id,@Param("newpassword") String newpassword);
}
