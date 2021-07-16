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

    @Select("select * from replay where from_id=#{uuid} and is_delete=false")
    @Results({
            @Result(property = "uuid",column = "uuid"),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content")
    })
    public List<Replay> getReplayListByFromID(@Param("uuid")String id);

    @Select("select * from replay where uuid=#{uuid} and is_delete=false")
    @Results({
            @Result(property = "uuid",column = "uuid"),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content")
    })
    public Replay getReplayByID(@Param("uuid")String id);

    @Insert("insert into replay(uuid,from_id,user_uuid,create_time,content) values(#{replay.uuid},#{replay.fromId},#{replay.userUuid},#{replay.createTime},#{replay.content})")
    public int insertReplay(@Param("replay")Replay replay);


    @Select("select * from replay where is_delete=false and (content like #{str}) ")
    @Results({
            @Result(property = "uuid",column = "uuid"),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content"),
    })
    public List<Replay> searchReplay(@Param("str") String str);

    @Update("update replay set is_delete=true where uuid=#{uuid}")
    public int deleteReplay(@Param("uuid")String id);

    @Update("update replay set is_delete=false where uuid=#{uuid}")
    public int cancelDeleteReplay(String uuid);
}

