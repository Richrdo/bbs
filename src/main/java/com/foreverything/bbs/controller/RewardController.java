package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.RewardService;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RewardController
 * @Author Yanlan_Li
 * Date 11:07 2019/12/17
 * @Description
 */
@RestController
public class RewardController {


    @Autowired
    RewardService rewardService;

    @GetMapping("/reward")
    public List<Reward> getReward(){
        return rewardService.getAllReward();
    }

    @PostMapping("/reward")
    public int createNewTopic(Reward reward){
        return rewardService.insertReward(reward);
    }
}
