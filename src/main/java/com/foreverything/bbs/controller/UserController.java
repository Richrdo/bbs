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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
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

    ModelAndView modelAndView;

    @PostMapping("/login")
    public ModelAndView userLogin(@RequestParam("mail") String mail, @RequestParam("password") String password, HttpServletRequest request){
        ModelAndView mv=new ModelAndView();

        int userID=userService.getIDByMail(mail);
        String pw=userService.getPas(userID);
        if (null==pw){
            mv.addObject("message","该用户不存在");
            mv.setViewName("login");
        }else if (pw.equals(password)){
            mv.addObject("isAdmin",userService.judgeUserByID(userID));
            request.getSession().setAttribute("userID",userID);
            request.getSession().setAttribute("user",userService.getUserByID(userID));
            mv.setViewName("index");
        }else{
            mv.addObject("message","密码错误");
            mv.setViewName("login");
        }

        return mv;
    }

    @PostMapping("/register")
    public ModelAndView createUser(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("mail") String mail, HttpServletResponse response){
        int id=userService.insertUser(name,password,mail);
        ModelAndView mv=new ModelAndView();
        if (id>0){
            mv.addObject("message","注册成功，您的id为："+id);
            mv.setViewName("login");
        }else{
            mv.addObject("message","注册失败，您的邮箱已注册");
            mv.setViewName("register");
        }
        return mv;
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

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/register")
    public String Register(){
        return "register";
    }
}
