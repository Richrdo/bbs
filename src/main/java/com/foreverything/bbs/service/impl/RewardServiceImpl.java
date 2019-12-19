package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.mapper.RewardMapper;
import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.mapper.UserMapper;
import com.foreverything.bbs.service.RewardService;
import com.foreverything.bbs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    UserMapper userMapper;

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
    public Long insertReward(Reward reward) {
       /**
       *@Author:Yanlan_Li
       *@Date:11:22 2019/12/17
       *@param:
       *  * @param topic
       *@Descriptoon:
       */
        reward.setId(IDUtil.initID());

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();

        reward.setCreateTime(dateFormat.format(date));

        if (rewardMapper.insertReward(reward)>0){
            return reward.getId();
        }else
            return 0L;
    }

    //根据id查找特定的悬赏
    @Override
    public Reward getRewardByID( Long id){
        return rewardMapper.getRewardByID(id);
    }


    //设置最佳回答
    @Override
    public int setBestReplay(Replay replay, Reward reward){
        return rewardMapper.setBestReplay(replay,reward);
    }

    //创建者修改悬赏内容
    @Override
    public int putReward(Reward reward){
        return rewardMapper.putReward(reward);
    }

    @Override
    public int deleteReward(Reward reward){
        return rewardMapper.deleteReward(reward);
    }

    @Override
    public boolean isEnough(int point, int id) {
        if (point<userMapper.getPointsByID(id)){
            return true;
        }else
        return false;
    }


}
