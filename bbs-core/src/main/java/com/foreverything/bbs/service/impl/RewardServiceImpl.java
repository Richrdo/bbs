package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.mapper.RewardMapper;
import com.foreverything.bbs.mapper.UserMapper;
import com.foreverything.bbs.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public int insertReward(Reward reward) {

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();

        reward.setCreateTime(dateFormat.format(date));

        if (rewardMapper.insertReward(reward)>0){
            reward.setId(rewardMapper.getContentId());
            return reward.getId();
        }
            return -1;
    }

    //根据id查找特定的悬赏
    @Override
    public Reward getRewardByID( int id){
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
    public int deleteReward(int id){
        return rewardMapper.deleteReward(id);
    }

    @Override
    public int cancelDeleteReward(int id){
        return rewardMapper.cancelDeleteReward(id);
    }

    @Override
    public boolean isEnough(int point, int id) {
        return point <= userMapper.getPointsById(id);
    }


}
