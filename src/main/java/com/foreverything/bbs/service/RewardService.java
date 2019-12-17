package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;

import java.util.List;

/**
 * @ClassName RewardService
 * @Author Yanlan_Li
 * Date 11:08 2019/12/17
 * @Description
 */
public interface RewardService {

    List<Reward> getAllReward();

    int insertReward(Reward reward);

}
