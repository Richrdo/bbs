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
    public  boolean getID(int id){
        if(userMapper.getID().contains(id))
            return true;
        return false;
    }
    @Override
    public String getPas(int id){
        return userMapper.getPas(id);
    }


    @Override
    public void insertUser(String username,String password,String mail){
        User user=new User();
        //user.setUserID(IDUtil.initUserID());
        user.setAccount(username);
        user.setPassword(password);
        user.setMail(mail);
        user.setGrade(0);
        userMapper.insertUser(user);

    }

    @Override
    public boolean updateAcc(int id, String new_account) {
       return userMapper.updateAcc(id,new_account);
    }

    @Override
    public boolean updatePas(int id,String newpassword){
       return userMapper.updatePas(id,newpassword);
    }

}
