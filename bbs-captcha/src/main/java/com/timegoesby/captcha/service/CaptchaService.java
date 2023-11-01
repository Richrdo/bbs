package com.timegoesby.captcha.service;

import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.bbscommon.vo.CaptchaVo;

public interface CaptchaService {

    String randomCaptcha();

    void saveCaptcha(String email,String captcha);

    R<String> verify(CaptchaVo captchaVo);

}
