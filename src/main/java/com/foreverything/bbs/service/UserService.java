package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.User;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Author LiuJingxin
 * @Date Created in 19:17 2019/12/17
 * @Description
 */
public interface UserService {

     String getPas(String id);

     String insertUser(String username, String password, String mail);

     Boolean judgeUserByID(String uuid);

     String getIDByMail(String mail);

     String getPasswordByEmail(String mail);

     User getUserByEmail(String email);


     int getUserPoints(String uuid);
}
