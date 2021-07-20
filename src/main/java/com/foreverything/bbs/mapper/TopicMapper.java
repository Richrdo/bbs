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
            @Result(property = "uuid",column = "uuid",id = true),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "isTop",column = "is_top"),
            @Result(property = "isMarrow",column = "is_marrow")
    })
    List<Topic> getAllTopic();

    @Select("select * from topic where uuid=#{uuid}")
    @Results({
            @Result(property = "uuid",column = "uuid",id = true),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "isTop",column = "is_top"),
            @Result(property = "isMarrow",column = "is_marrow")
    })
    Topic getTopicByID(@Param("uuid")String id);

    @Insert("insert into topic(uuid,user_uuid,title,content,create_time) values(#{topic.uuid},#{topic.userUuid},#{topic.title},#{topic.content},#{topic.createTime})")
    public int insertTopic(@Param("topic") Topic topic);


    @Update("update topic set title=#{topic.title},content=#{topic.content} where uuid=#{topic.uuid}")
    public int updateTopic(@Param("topic")Topic topic);

    @Update("update topic set is_marrow=true where uuid=#{uuid}")
    public int marrowTopicByID(@Param("uuid")String id);

    @Update("update topic set is_top=true where uuid=#{uuid}")
    public int upTopicByID(@Param("uuid")String id);

    @Update("update topic set is_delete=true where uuid=#{uuid}")
    public int deleteTopicByID(@Param("uuid")String id);

    @Update("update topic set is_marrow=false where uuid=#{uuid}")
    public int cancelMarrowTopicByID(@Param("uuid")String id);

    @Update("update topic set is_top=false where uuid=#{uuid}")
    public int cancelUpTopicByID(@Param("uuid")String id);

    @Select("select * from topic where is_delete=false and (title like #{str} or content like #{str}) ")
    @Results({
            @Result(property = "uuid",column = "uuid",id = true),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "content",column = "content"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "isDelete",column = "is_delete"),
            @Result(property = "title",column = "title"),
            @Result(property = "points",column = "points"),
            @Result(property = "isMarrow",column = "is_marrow"),
            @Result(property = "isTop",column = "is_top"),
    })
    public List<Topic> searchTopic(@Param("str") String str);
}
