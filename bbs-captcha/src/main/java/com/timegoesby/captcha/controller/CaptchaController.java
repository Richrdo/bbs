package com.timegoesby.captcha.controller;

import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.captcha.service.CaptchaService;
import com.timegoesby.captcha.service.EmailService;
import com.timegoesby.bbscommon.vo.CaptchaVo;
import com.timegoesby.bbscommon.vo.EmailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verification")
public class CaptchaController {

    @Autowired
    EmailService emailService;

    @Autowired
    CaptchaService captchaService;

    @RequestMapping("/test")
    public R<String> test(){
        return R.success();
    }

    @RequestMapping("/send")
    public R<String> sendCaptcha(@RequestBody EmailVo emailVo){
        return emailService.sendCaptcha(emailVo);
    }

    @RequestMapping("/verify")
    public R<String> verify(@RequestBody CaptchaVo captchaVo){
        return captchaService.verify(captchaVo);
    }

}
