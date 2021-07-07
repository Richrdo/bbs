package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName RewardService
 * @Author Yanlan_Li
 * Date 11:08 2019/12/17
 * @Description
 */
public interface RewardService {

    /**
    *@Author:Yanlan_Li
    *@Date:19:30 2019/12/18
    *@param:
    *  * @param null
    *@Descriptoon:显示悬赏列表
    */
    List<Reward> getAllReward();

    /**
    *@Author:Yanlan_Li
    *@Date:19:31 2019/12/18
    *@param:
    *  * @param null
    *@Descriptoon:发布悬赏
    */
    String insertReward(Reward reward);

     /**
     *@Author:Yanlan_Li
     *@Date:19:31 2019/12/18
     *@param:
     *  * @param null
     *@Descriptoon:根据id查找特定的悬赏
     */
    Reward getRewardByID( String id);

    /**
    *@Author:Yanlan_Li
    *@Date:19:31 2019/12/18
    *@param:
    *  * @param null
    *@Descriptoon:设置最佳回答
    */
    int setBestReplay(Replay replay, Reward reward);


    /**
    *@Author:Yanlan_Li
    *@Date:19:32 2019/12/18
    *@param:
    *  * @param null
    *@Descriptoon:创建者修改悬赏内容
     */
    int putReward(Reward reward);

    /**
    *@Author:Yanlan_Li
    *@Date:19:32 2019/12/18
    *@param:
    *  * @param null
    *@Descriptoon:删除悬赏
    */
    int deleteReward(String id);
    
    /**
     * @Author:刘光辉
     * @Date:10:23 2019/12/20
     * @param:
     *  * @param null
     * 
     * @Desccription:
     */
    int cancelDeleteReward(String id);

    /**
     * @Author:Yanlan_Li
     * @Date:23:56 2019/12/18
     * @param:
     *  * @param null
     *
     * @Desccription:根据id判断悬赏点数是否足够。
     */
    boolean isEnough(int point,String uuid);
}
