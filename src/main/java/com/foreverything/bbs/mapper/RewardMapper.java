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

    @Select("select * from reward where r_is_delete=false")  //显示悬赏列表
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

    @Insert("insert into reward(r_id,r_author_id,r_content,r_create_time,r_title,r_point) values(#{reward.id},#{reward.userID},#{reward.content},#{reward.createTime},#{reward.title},#{reward.point})")
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
     Reward getRewardByID(@Param("id") Long id);

    //插入回复
    @Insert("insert into replay(c_id,c_from_id,c_author_id,c_create_time,c_content) values(#{replay.id},#{replay.fromID},#{replay.userID},#{replay.createTime},#{replay.content})")
    int insertReplay(@Param("replay")Replay replay);

    //设置最佳回答，//将积分给用户（不是我的事）
    @Update("update reward set r_best_replay=#{replay.id} where r_id=#{reward.id}")//设置最佳回答
     int setBestReplay(@Param("replay")Replay replay,@Param("reward")Reward reward);

    //创建者修改悬赏内容
    @Update("update reward set r_content=#{reward.content},r_title=#{reward.title},r_points=#{reward.points} where r_id=#{reward.id}")
     int putReward(@Param("reward")Reward reward);

    //据帖子id获取回复列表
     @Select("select * from replay where c_from_id=#{rewardId}")
     @Results({
             @Result(property = "id",column = "c_id",id = true),
             @Result(property = "userID",column = "c_author_id"),
             @Result(property = "fromID",column = "c_from_id"),
             @Result(property = "createTime",column = "c_create_time"),
             @Result(property = "isDelete",column = "c_is_delete"),
             @Result(property = "content",column = "c_content"),
     })
     List<Replay> getAllReplayByID(@Param("rewardId") Long rewardId);
}
