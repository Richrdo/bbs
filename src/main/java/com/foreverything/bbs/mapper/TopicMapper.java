package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
