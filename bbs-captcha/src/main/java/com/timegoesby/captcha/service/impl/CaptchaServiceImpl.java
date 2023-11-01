package com.timegoesby.captcha.service.impl;

import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.captcha.service.CaptchaService;
import com.timegoesby.captcha.utils.RedisUtil;
import com.timegoesby.bbscommon.vo.CaptchaVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Log4j2
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    RedisUtil redisUtil;

    @Value("${captcha.livetime}")
    private int liveTime;

    @Override
    public String randomCaptcha() {
        Random random = new Random();
        int num = random.nextInt(999999);
        String captcha = String.format("%06d",num);
        return captcha;
    }

    @Override
    public void saveCaptcha(String email, String captcha) {
        System.out.println("save in redis "+email+"\t"+captcha);
        redisUtil.set(email, captcha.trim(),liveTime );
    }

    @Override
    public R<String> verify(CaptchaVo captchaVo) {
        String captcha = (String) redisUtil.get(captchaVo.getEmail());
        System.out.println("verify "+captchaVo.getEmail()+"\t"+captchaVo.getCaptcha()+"\t"+captcha);
        if (captchaVo.getCaptcha().equals(captcha)){
            redisUtil.expire(captchaVo.getEmail(),0);
            return R.success("验证成功");
        };
        return R.fail("验证失败");
    }
}
