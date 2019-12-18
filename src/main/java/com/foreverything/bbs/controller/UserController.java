package com.foreverything.bbs.controller;


import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.PrintWriter;
import java.util.List;


/**
 * @ClassName UserController
 * @Author LiuJingxin
 * @Date Created in 15:10 2019/12/17
 * @Description
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ModelAndView userLogin(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        int userID=Integer.parseInt(id);
        String pw=userService.getPas(userID);

        if (null==pw){
            mv.addObject("msg","该用户不存在");
            mv.setViewName("login");
        }else if (pw.equals(password)){
            mv.addObject("msg","登入成功");
            request.getSession().setAttribute("userID",userID);
            mv.setViewName("index");
        }else{
            mv.addObject("msg","密码错误");
            mv.setViewName("login");
        }

        return mv;
    }

    @PostMapping("/register")
    public String createUser(User user,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("mail") String mail){
        userService.insertUser(username,password,mail);
        return "login";
    }


    @GetMapping("/quit")
    public String quitLogin(HttpServletRequest request){
        /**
         * @Author: 刘光辉
         * @Date:20:05 2019/12/18
         * @param:
         *  * @param request
         *
         * @Desccription: 退出时清空session
         */
        request.getSession().invalidate();

        return "index";
    }
}
