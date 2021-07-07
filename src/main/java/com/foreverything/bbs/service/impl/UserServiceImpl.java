package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.mapper.UserMapper;
import com.foreverything.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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
    UserMapper userMapper;


    @Override
    public String getPas(String id){
        return userMapper.getPas(id);
    }

    @Override
    public String insertUser(String username,String password,String mail){
        User user=new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setName(username);
        user.setPassword(password);
        user.setEmail(mail);
        user.setGrade(0);
        if (userMapper.insertUser(user)>0){
            return user.getUuid();
        }else
        return null;
    }

    @Override
    public Boolean judgeUserByID(String uuid) {
        return userMapper.isAdmin(uuid);
    }

    @Override
    public String getIDByMail(String mail) {
        return userMapper.getUUIDByEmail(mail);
    }

    @Override
    public String getPasswordByEmail(String mail) {
        return userMapper.getPas(mail);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public Map<Integer,String> getUserMap() {
        Map<Integer,String> map=new HashMap<>();
        userMapper.getUserIDMap().forEach(e->{
            map.put(e.getId(),e.getName());
        });
        return map;
    }

    @Override
    public int getUserPoints(String uuid) {
        return userMapper.getUserPoint(uuid);
    }


}
