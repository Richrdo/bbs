package com.timegoesby.captcha.service;

import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.bbscommon.vo.EmailVo;


public interface EmailService   {

    public R<String> sendCaptcha(EmailVo emailVo);

}
