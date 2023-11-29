package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.entities.User_old;

/**
 * @ClassName UserService
 * @Author LiuJingxin
 * @Date Created in 19:17 2019/12/17
 * @Description
 */
public interface UserService {

     boolean insertUser(String username, String password, String mail);

     User getUserByEmail(String email);

     int getUserPointsByEmail(String email);
}
