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

    @Select("select * from topic where t_is_delete=false")
    @Results({
            @Result(property = "id",column = "t_id",id = true),
            @Result(property = "userID",column = "t_author_id"),
            @Result(property = "createTime",column = "t_create_time"),
            @Result(property = "content",column = "t_content"),
            @Result(property = "isMarrow",column = "t_is_marrow"),
            @Result(property = "title",column = "t_title"),
            @Result(property = "isDelete",column = "t_is_delete"),
            @Result(property = "isTop",column = "t_is_top")
    })
    List<Topic> getAllTopic();

    @Select("select * from topic where t_id=#{id}")
    @Results({
            @Result(property = "id",column = "t_id",id = true),
            @Result(property = "userID",column = "t_author_id"),
            @Result(property = "createTime",column = "t_create_time"),
            @Result(property = "content",column = "t_content"),
            @Result(property = "isMarrow",column = "t_is_marrow"),
            @Result(property = "title",column = "t_title"),
            @Result(property = "isDelete",column = "t_is_delete"),
            @Result(property = "isTop",column = "t_is_top")
    })
    Topic getTopicByID(@Param("id")Long id);

    @Insert("insert into topic(t_id,t_author_id,t_title,t_content,t_create_time) values(#{topic.id},#{topic.userID},#{topic.title},#{topic.content},#{topic.createTime})")
    public int insertTopic(@Param("topic") Topic topic);

    @Select("select t_id from topic")
    public List<Long> getTopicIdCollection();

    @Update("update topic set t_title=#{topic.title},t_content=#{topic.content} where t_id=#{topic.id}")
    public int updateTopic(@Param("topic")Topic topic);

    @Update("update topic set t_is_marrow=true where t_id=#{id}")
    public int marrowTopicByID(@Param("id")Long id);

    @Update("update topic set t_is_top=true where t_id=#{id}")
    public int upTopicByID(@Param("id")Long id);

    @Update("update topic set t_is_delete=true where t_id=#{id}")
    public int deleteTopicByID(@Param("id")Long id);

    @Update("update topic set t_is_marrow=false where t_id=#{id}")
    public int cancelMarrowTopicByID(@Param("id")Long id);

    @Update("update topic set t_is_up=false where t_id=#{id}")
    public int cancelUpTopicByID(@Param("id")Long id);

    @Select("select * from topic where t_is_delete=false and (t_title like #{str} or t_content like #{str}) ")
    @Results({
            @Result(property = "id",column = "t_id",id = true),
            @Result(property = "userID",column = "t_author_id"),
            @Result(property = "createTime",column = "t_create_time"),
            @Result(property = "content",column = "t_content"),
            @Result(property = "isMarrow",column = "t_is_marrow"),
            @Result(property = "title",column = "t_title"),
            @Result(property = "isTop",column = "t_is_top")
    })
    public List<Topic> searchTopic(@Param("str") String str);
}
