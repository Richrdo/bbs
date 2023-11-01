package com.foreverything.bbs.service;

import com.timegoesby.bbscommon.constant.R;
import com.timegoesby.bbscommon.vo.CaptchaVo;
import com.timegoesby.bbscommon.vo.EmailVo;


public interface VerificationService {

    public R<String> sendCaptcha(EmailVo emailVo);

    public R<String> verifyCaptcha(CaptchaVo captchaVo);

}
