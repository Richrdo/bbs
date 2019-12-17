package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Replay;
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

    //显示悬赏列表
    List<Reward> getAllReward();

    //发布悬赏
    int insertReward(Reward reward);

    //查找所有悬赏的id
    List<Long> getRewardIdCollection();

    //根据id查找特定的悬赏
    Reward getSpecificReward( Long id);

    //插入回复
    int setReplay(Replay replay);


   //设置最佳回答
    int setBestReplay(Replay replay, Reward reward);

    //创建者修改悬赏内容

    int resetReward(Reward reward);

}
