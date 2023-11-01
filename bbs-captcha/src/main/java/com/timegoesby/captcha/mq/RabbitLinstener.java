package com.timegoesby.captcha.mq;

import com.timegoesby.bbscommon.vo.EmailVo;
import com.timegoesby.captcha.service.CaptchaService;
import com.timegoesby.captcha.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitLinstener {
    @Autowired
    CaptchaService captchaService;

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "captcha")
    public void listenSimpleQueueMessage(EmailVo emailVo) throws InterruptedException{
        System.out.println("接收到消息: "+emailVo.toString());
        emailService.sendCaptcha(emailVo);
        System.out.println("处理完成");
    }
}
