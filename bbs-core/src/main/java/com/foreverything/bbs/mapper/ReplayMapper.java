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

    @Select("select * from replay where from_id=#{id} and is_delete=false")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "userId"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content"),
            @Result(property = "fromType",column = "from_type"),
            @Result(property = "fromId",column = "from_id"),
    })
    public List<Replay> getReplayListByFromID(@Param("id")int id);

    @Select("select * from replay where uuid=#{id} and is_delete=false")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content"),
            @Result(property = "fromId",column = "from_id"),
            @Result(property = "fromType",column = "from_type")
    })
    public Replay getReplayByID(@Param("id")int id);

    @Select("SELECT LAST_INSERT_ID()")
    public int getContentId();

    @Insert("insert into replay(from_id,user_uuid,create_time,content,from_type) values(#{replay.fromId},#{replay.userUuid},#{replay.createTime},#{replay.content},#{replay.fromType})")
    public int insertReplay(@Param("replay")Replay replay);


    @Select("select * from replay where is_delete=false and (content like #{str}) ")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content"),
            @Result(property = "fromId",column = "from_id"),
            @Result(property = "fromType",column = "from_type")
    })
    public List<Replay> searchReplay(@Param("str") String str);

    @Update("update replay set is_delete=true where id=#{id}")
    public int deleteReplay(@Param("id")int id);

    @Update("update replay set is_delete=false where id=#{id}")
    public int cancelDeleteReplay(int id);

}

