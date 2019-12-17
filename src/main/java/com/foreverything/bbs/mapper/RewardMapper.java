package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName RewardMapper
 * @Author Yanlan_Li
 * Date 11:11 2019/12/17
 * @Description
 */
@Mapper
public interface RewardMapper {

    @Select("select * from reward where t_is_delete=false")  //显示悬赏列表
    @Results({
            @Result(property = "id",column = "r_id",id = true),
            @Result(property = "userID",column = "r_author_id"),
            @Result(property = "content",column = "r_content"),
            @Result(property = "createTime",column = "r_create_time"),
            @Result(property = "isDelete",column = "r_is_delete"),
            @Result(property = "title",column = "r_title"),
            @Result(property = "point",column = "r_point"),
            @Result(property = "bestreplay",column = "r_best_replay")
    })
    List<Reward> getAllReward();

    @Insert("insert into reward(r_id,r_author_id,r_content,r_create_time,r_is_delete,r_title,r_point) values(#{reward.id},#{reward.userID},#{reward.content},#{reward.createTime},#{reward.isDelete},#{reward.title},#{reward.point})")
     int insertReward(@Param("reward") Reward reward); //发布悬赏

    @Select("select r_id from reward")  //查找所有悬赏的id
     List<Long> getRewardIdCollection();

    /**
    *@Author:Yanlan_Li
    *@Date:14:14 2019/12/17
    *@param:
    *  * @param null
    *@Descriptoon:
    */
    //根据id查找特定的悬赏
    @Select("select * from reward where r_id=id")
     Reward getSpecificReward(Long id);

    //插入回复
    @Insert("insert into commentary(c_id,c_from_id,c_author_id,c_is_delete,c_create_time,c_content) values(#{replay.id),#{replay.fromID},#{replay.userId},#{replay.isdelete},#{replay.createTime},#{replay.content}")
     void setCommentary(Replay replay);

    //设置最佳回答，//将积分给用户（不是我的事）
    @Update("Update reward set r_best_replay=replay.getId() where r_id=reward.getId()")//设置最佳回答
     void setBestReplay(Replay replay,Reward reward);

    //创建者修改悬赏内容
    @Update("Update reward set r_content=reward.getContent(),r_title=reward.getTitle(),r_point=reward.getPoint() where r_id=reward.getId()")
     void resetReward(Reward reward);


}
