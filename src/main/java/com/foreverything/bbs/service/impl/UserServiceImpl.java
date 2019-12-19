package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.mapper.UserMapper;
import com.foreverything.bbs.service.UserService;
import com.foreverything.bbs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author LiuJingxin
 * @Date Created in 19:17 2019/12/17
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public String getPas(int id){
        return userMapper.getPas(id);
    }

    @Override
    public int insertUser(String username,String password,String mail){
        User user=new User();
        user.setId(IDUtil.initUserID());
        user.setName(username);
        user.setPassword(password);
        user.setMail(mail);
        user.setGrade(0);
        if (userMapper.insertUser(user)>0){
            return user.getId();
        }else
        return 0;
    }

    @Override
    public Boolean judgeUserByID(int id) {
        return userMapper.isAdmin(id);
    }

    @Override
    public int getIDByMail(String mail) {
        return userMapper.getIDByEmail(mail);
    }

    @Override
    public String getPasswordByEmail(String mail) {
        int id=userMapper.getIDByEmail(mail);
        if (id>0){
            return userMapper.getPas(id);
        }
        return null;
    }

    @Override
    public User getUserByID(int id) {
        return userMapper.getUserByID(id);
    }


}
