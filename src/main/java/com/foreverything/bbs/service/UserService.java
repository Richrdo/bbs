package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.User;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Author LiuJingxin
 * @Date Created in 19:17 2019/12/17
 * @Description
 */
@Service
public interface UserService {
     boolean getID(int id);
     String getPas(int id);
     void insertUser(String username, String password, String mail);
     boolean updatePas(int id,String newpassword);
     boolean updateAcc(int id,String new_account);
}
