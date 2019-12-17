package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.mapper.RewardMapper;
import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.service.RewardService;
import com.foreverything.bbs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RewardServiceImpl
 * @Author Yanlan_Li
 * Date 11:09 2019/12/17
 * @Description
 */
@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    RewardMapper rewardMapper;

    @Override
    public List<Reward> getAllReward() {
        /**
        *@Author:Yanlan_Li
        *@Date:11:22 2019/12/17
        *@param:
        *  * @param
        *@Descriptoon:
        */
        return rewardMapper.getAllReward();
    }

    @Override
    public int insertReward(Reward reward) {
       /**
       *@Author:Yanlan_Li
       *@Date:11:22 2019/12/17
       *@param:
       *  * @param topic
       *@Descriptoon:
       */

        //reward.setId(IDUtil.initRewardID());
        return rewardMapper.insertReward(reward);
    }

}
