package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.entities.User_old;
import com.foreverything.bbs.mapper.LoginMapper;
import com.foreverything.bbs.mapper.UserMapper;
import com.foreverything.bbs.mapper.UserRoleMapper;
import com.foreverything.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.beans.Transient;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Author LiuJingxin
 * @Date Created in 19:17 2019/12/17
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    @Transient()
    public boolean insertUser(String username,String password,String email){
        User user = new User();
        if (userMapper.insertUser(email,username,password)>0){
            int id = userMapper.getInsertedUserId();
            // TODO 这里写死了普通用户的role id是5，后续继续改进
            userRoleMapper.insertUserRole(id,5);
            return true;
        }
        return false;
    }


    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }


    @Override
    public int getUserPointsByEmail(String email) {
        return userMapper.getPointsByEmail(email);
    }


}
