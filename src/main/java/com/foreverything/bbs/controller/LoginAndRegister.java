package com.foreverything.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName LoginAndRegister
 * @Author LiuJingxin
 * @Date Created in 10:17 2019/12/17
 * @Description
 */
@Controller
public class LoginAndRegister {
    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/register")
    public String Register(){
        return "register";
    }

    @RequestMapping("/adminLogin")
    public String AdminLogin(){
        return "adminLogin";
    }
}
