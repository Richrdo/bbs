package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.service.VerificationService;
import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.bbscommon.vo.CaptchaVo;
import com.timegoesby.bbscommon.vo.EmailVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.captcha.queuename}")
    String queueName;

    @Override
    public R<String> sendCaptcha(EmailVo emailVo) {
        rabbitTemplate.convertAndSend(queueName,emailVo);
        System.out.println(emailVo.toString());
        return R.success();
    }

    @Override
    public R<String> verifyCaptcha(CaptchaVo captchaVo) {
        return null;
    }
}
