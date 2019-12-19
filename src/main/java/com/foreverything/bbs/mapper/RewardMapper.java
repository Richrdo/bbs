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
            @Result(property = "points",column = "r_points"),
            @Result(property = "bestreplay",column = "r_best_replay")
    })
    List<Reward> getAllReward();

    @Insert("insert into reward(r_id,r_author_id,r_content,r_create_time,r_title,r_points) values(#{reward.id},#{reward.userID},#{reward.content},#{reward.createTime},#{reward.title},#{reward.points})")
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
    @Select("select * from reward where r_id=#{id}")
    @Results({
            @Result(property = "id",column = "r_id",id = true),
            @Result(property = "userID",column = "r_author_id"),
            @Result(property = "content",column = "r_content"),
            @Result(property = "createTime",column = "r_create_time"),
            @Result(property = "isDelete",column = "r_is_delete"),
            @Result(property = "title",column = "r_title"),
            @Result(property = "points",column = "r_points"),
            @Result(property = "bestreplay",column = "r_best_replay")
    })
     Reward getRewardByID(@Param("id") Long id);


    //设置最佳回答
    @Update("update reward set r_best_replay=#{replay.id} where r_id=#{reward.id}")
     int setBestReplay(@Param("replay")Replay replay,@Param("reward")Reward reward);

    //删除悬赏
    @Update("update reward set r_is_delete=true where r_id=#{reward.id}")
    int deleteReward(@Param("reward")Reward reward);

    //创建者修改悬赏内容
    @Update("update reward set r_content=#{reward.content},r_title=#{reward.title},r_points=#{reward.points} where r_id=#{reward.id}")
     int putReward(@Param("reward")Reward reward);

    @Select("select * from reward where r_is_delete=false and (r_title like #{str} or r_content like #{str}) ")
    @Results({
            @Result(property = "id",column = "r_id",id = true),
            @Result(property = "userID",column = "r_author_id"),
            @Result(property = "createTime",column = "r_create_time"),
            @Result(property = "content",column = "r_content"),
            @Result(property = "title",column = "r_title"),
    })
    public List<Reward> searchReward(@Param("str") String str);
}
