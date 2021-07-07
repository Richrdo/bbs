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

    @Select("select * from reward where is_delete=false")  //显示悬赏列表
    @Results({
            @Result(property = "uuid",column = "uuid",id = true),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "bestReplay",column = "best_replay")
    })
    List<Reward> getAllReward();

    @Insert("insert into reward(uuid,user_uuid,content,create_time,title,points) values(#{reward.uuid},#{reward.userUuid},#{reward.content},#{reward.createTime},#{reward.title},#{reward.points})")
     int insertReward(@Param("reward") Reward reward); //发布悬赏

    /**
    *@Author:Yanlan_Li
    *@Date:14:14 2019/12/17
    *@param:
    *  * @param null
    *@Descriptoon:
    */
    //根据id查找特定的悬赏
    @Select("select * from reward where uuid=#{uuid}")
    @Results({
            @Result(property = "uuid",column = "uuid",id = true),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "bestReplay",column = "best_replay")
    })
     Reward getRewardByID(@Param("id") String id);


    //设置最佳回答
    @Update("update reward set best_replay=#{replay.uuid} where uuid=#{reward.uuid}")
     int setBestReplay(@Param("replay")Replay replay,@Param("reward")Reward reward);

    //删除悬赏
    @Update("update reward set is_delete=true where uuid=#{uuid}")
    int deleteReward(String uuid);

    //创建者修改悬赏内容
    @Update("update reward set content=#{reward.content},title=#{reward.title} where uuid=#{reward.uuid}")
     int putReward(@Param("reward")Reward reward);

    @Update("update reward set is_delete=false where uuid=#{uuid}")
    int cancelDeleteReward(String uuid);

    @Select("select * from reward where is_delete=false and (title like #{str} or content like #{str}) ")
    @Results({
            @Result(property = "uuid",column = "uuid",id = true),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "bestReplay",column = "best_replay")
    })
    public List<Reward> searchReward(@Param("str") String str);
}
