package com.foreverything.bbs.feign;

import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.bbscommon.vo.CaptchaVo;
import com.timegoesby.bbscommon.vo.EmailVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "bbs-captcha")
public interface CaptchaFeign {

    @RequestMapping("/api/verification/send")
    public R<String> sendCaptcha(@RequestBody EmailVo emailVo);

    @RequestMapping("/api/verification/verify")
    public R<String> verify(@RequestBody CaptchaVo captchaVo);

}
