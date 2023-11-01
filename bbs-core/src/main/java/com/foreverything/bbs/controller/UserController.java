package com.foreverything.bbs.controller;


import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.feign.CaptchaFeign;
import com.foreverything.bbs.service.UserService;
import com.foreverything.bbs.service.VerificationService;
import com.timegoesby.bbscommon.constant.CodeEnums;
import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.bbscommon.vo.CaptchaVo;
import com.timegoesby.bbscommon.vo.EmailVo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

    @Autowired
    VerificationService verificationService;

    @PostMapping("/login")
    public ModelAndView userLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) {


        ModelAndView mv = new ModelAndView();
        System.out.println("进入login post . email ：" + email + " pwd: " + password);
        String pw = userService.getPas(email);
        if (null == pw) {
            mv.addObject("message", "该用户不存在");
            mv.setViewName("login");
        } else if (pw.equals(password)) {
            User user = userService.getUserByEmail(email);
            System.out.println("登入用户是: " + user.toString());
            request.getSession().setAttribute("isAdmin", user.isAdmin());
            request.getSession().setAttribute("userName", user.getName());
            request.getSession().setAttribute("userUuid", user.getUuid());
            request.getSession().setAttribute("userEmail", user.getEmail());
            request.getSession().setAttribute("userPoints", user.getGrade());
            mv.setViewName("index");
        } else {
            mv.addObject("message", "密码错误");
            mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping("/verification/captcha/send")
    @ResponseBody
    public R<String> send(@RequestBody EmailVo emailVo) {
        return verificationService.sendCaptcha(emailVo);
    }

    @PostMapping("/register")
    public ModelAndView createUser(@RequestParam("name") String name, @RequestParam("repassword") String repassword, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("captcha") String captcha, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");

        if (null == password || !password.equals(repassword)) {
            mv.addObject("message", "两次密码不一致");

        } else if (userService.getUserByEmail(email) != null) {
            mv.addObject("message", "该邮箱已注册");
        } else if (verificationService.verifyCaptcha(new CaptchaVo(email, captcha)).getCode() != CodeEnums.SUCCESS.getCode()) {
            mv.addObject("message", "验证码错误");
        } else {
            String uuid = userService.insertUser(name, password, email);

            if (uuid != null) {
                mv.addObject("message", "注册成功，您的id为：" + uuid + ",请牢记");
                mv.setViewName("login");
            } else {
                mv.addObject("message", "注册失败");
            }
        }
        return mv;
    }

    /**
     * @Author: 刘光辉
     * @Date:20:05 2019/12/18
     * @param: * @param request
     * @Desccription: 退出时清空session
     */
    @GetMapping("/quit")
    public String quitLogin(HttpServletRequest request) {

        request.getSession().invalidate();

        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        System.out.println("接收到get login方法");
        return "login";
    }

    @GetMapping("/register")
    public String Register() {

        System.out.println("接收到register get 请求");
        return "register";
    }
}
