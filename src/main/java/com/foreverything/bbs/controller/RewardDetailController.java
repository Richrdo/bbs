package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.ReplayService;
import com.foreverything.bbs.service.RewardService;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName RewardDetailController
 * @Author Yanlan_Li
 * Date 17:50 2019/12/18
 * @Description
 */
@Controller
public class RewardDetailController {

    @Autowired
    ReplayService replayService;

    @Autowired
    RewardService rewardService;

    @GetMapping("/rewardDetail")
    public ModelAndView getRewardDetail(@RequestParam(value = "id") Long id){
        ModelAndView mv=new ModelAndView();
        Reward reward = rewardService.getRewardByID(id);
        System.out.println("点击的reward："+reward);
        mv.addObject("obj",reward);
        List<Replay> replayList=replayService.getReplayListByID(id);
        mv.addObject("replays",replayList);
        mv.setViewName("rewardDetailPage");
        return mv;
    }
}
