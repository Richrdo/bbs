package com.foreverything.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName LoginAndRegister
 * @Author LiuJingxin
 * @Date Created in 10:17 2019/12/17
 * @Description
 */
@Controller
public class LoginAndRegister {

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/register")
    public String Register(){
        return "register";
    }

    @GetMapping("/adminLogin")
    public String AdminLogin(){
        return "adminLogin";
    }
}
