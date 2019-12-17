package com.foreverything.bbs.mapper;

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

    @Select("select * from topic where t_is_delete=false")
    @Results({
            @Result(property = "id",column = "t_id",id = true),
            @Result(property = "userID",column = "t_author_id"),
            @Result(property = "createTime",column = "t_create_time"),
            @Result(property = "content",column = "t_content"),
            @Result(property = "isMarrow",column = "t_is_marrow"),
            @Result(property = "title",column = "t_title"),
            @Result(property = "isDelete",column = "t_is_delete")
    })
    List<Topic> getAllTopic();

    @Insert("insert into topic(t_id,t_author_id,t_title,t_content,t_create_time,t_is_marrow,t_is_delete) values(#{topic.id},#{topic.userID},#{topic.title},#{topic.content},#{topic.createTime},#{topic.isMarrow},#{topic.isDelete})")
    public int insertTopic(@Param("topic") Topic topic);

    @Select("select t_id from topic")
    public List<Long> getTopicIdCollection();


}
