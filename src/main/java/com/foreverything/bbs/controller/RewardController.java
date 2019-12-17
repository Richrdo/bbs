package com.foreverything.bbs.controller;

import com.foreverything.bbs.service.RewardService;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName RewardController
 * @Author Yanlan_Li
 * Date 21:59 2019/12/17
 * @Description
 */
@Controller
public class RewardController {
    @Autowired
    RewardService rewardService;

}
