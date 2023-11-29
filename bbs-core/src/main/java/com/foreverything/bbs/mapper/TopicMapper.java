package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName TopicMapper
 * @Author CeaserBorgia
 * @Date 9:19 2019/12/16
 * @Description
 */

@Mapper
public interface TopicMapper {

    @Select("select * from topic where is_delete=false")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "isTop",column = "is_top"),
            @Result(property = "isMarrow",column = "is_marrow")
    })
    List<Topic> getAllTopic();

    @Select("select * from topic where id=#{id}")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "isTop",column = "is_top"),
            @Result(property = "isMarrow",column = "is_marrow")
    })
    Topic getTopicByID(@Param("id")int id);

    @Insert("insert into topic(user_id,title,content,create_time) values(#{topic.userId},#{topic.title},#{topic.content},#{topic.createTime})")
    public int insertTopic(@Param("topic") Topic topic);

    @Select("SELECT LAST_INSERT_ID()")
    public int getContentId();

    @Update("update topic set title=#{topic.title},content=#{topic.content} where id=#{topic.id}")
    public int updateTopic(@Param("topic")Topic topic);

    @Update("update topic set is_marrow=true where uuid=#{id}")
    public int marrowTopicByID(@Param("uuid")int id);

    @Update("update topic set is_top=true where uuid=#{id}")
    public int upTopicByID(@Param("uuid")int id);

    @Update("update topic set is_delete=true where id=#{id}")
    public int deleteTopicByID(@Param("uuid")int id);

    @Update("update topic set is_marrow=false where id=#{id}")
    public int cancelMarrowTopicByID(@Param("uuid")int id);

    @Update("update topic set is_top=false where id=#{id}")
    public int cancelUpTopicByID(@Param("id")int id);

    @Select("select * from topic where is_delete=false and (title like #{str} or content like #{str}) ")
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "isTop",column = "is_top"),
            @Result(property = "isMarrow",column = "is_marrow")
    })
    public List<Topic> searchTopic(@Param("str") String str);
}
