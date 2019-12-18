package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Replay;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ReplayMapper
 * @Author 刘光辉
 * @Date 23:45  2019/12/17
 * @Description
 */

@Mapper
public interface ReplayMapper {

    @Select("select * from replay where r_from_id=#{id} and r_is_delete=false")
    @Results({
            @Result(property = "id",column = "r_id",id = true),
            @Result(property = "userID",column = "r_author_id"),
            @Result(property = "createTime",column = "r_create_time"),
            @Result(property = "content",column = "r_content")
    })
    public List<Replay> getReplayListByFromID(@Param("id")Long id);

    @Select("select * from replay where r_id=#{id} and r_is_delete=false")
    @Results({
            @Result(property = "id",column = "r_id",id = true),
            @Result(property = "userID",column = "r_author_id"),
            @Result(property = "createTime",column = "r_create_time"),
            @Result(property = "content",column = "r_content")
    })
    public Replay getReplayByID(@Param("id")Long id);

    @Insert("insert into replay(r_id,r_from_id,r_author_id,r_create_time,r_content) values(#{replay.id},#{replay.fromID},#{replay.userID},#{replay.createTime},#{replay.content})")
    public int insertReplay(@Param("replay")Replay replay);

    @Select("select r_id from replay")
    public List<Long> getReplayIDList();
}

