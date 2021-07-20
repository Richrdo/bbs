package com.foreverything.bbs.mapper;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RewardMapper
 * @Author ying_tie
 * Date 15:05 2019/12/16
 * @Description
 */
@Mapper
@Service
public interface ArticleMapper {
    @Select("select * from article where is_delete=false")
    @Results({
            @Result(property = "uuid", column = "uuid"),
            @Result(property = "userUuid", column = "user_uuid"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "isMarrow", column = "is_marrow"),
            @Result(property = "isDelete", column = "is_delete")
    })
    abstract List<Article> getAllArticle();

    @Select("select * from article where uuid=#{uuid}")
    @Results({
            @Result(property = "uuid", column = "uuid"),
            @Result(property = "userUuid", column = "user_uuid"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "isMarrow", column = "is_marrow"),
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "isTop",column = "is_top")
    })
    Article getArticleByID(@Param("uuid")String id);

    @Insert("insert into article(uuid,user_uuid,title,content,create_time) values(#{article.uuid},#{article.userUuid},#{article.title},#{article.content},#{article.createTime})")
    public int insertArticle(@Param("article") Article article);


    @Update("update article set title=#{article.title},content=#{article.content} where uuid=#{article.uuid}")
    public int updateArticle(@Param("article")Article article);

    @Update("update article set is_delete=true where uuid=#{uuid}")
    public int deleteArticleByID(@Param("uuid")String uuid);

    @Update("update article set is_top=false where uuid=#{uuid}")
    public int cancelUpArticleByID(@Param("uuid")String uuid);

    @Update("update article set is_top=true where uuid=#{uuid}")
    public int upArticle(@Param("uuid")String uuid);

    @Update("update article set is_marrow=true where uuid=#{uuid}")
    public int marrowArticleByID(@Param("uuid")String uuid);

    @Update("update article set is_marrow=false where uuid=#{uuid}")
    public int cancelMarrowArticleByID(@Param("uuid")String uuid);

    @Select("select * from article where is_delete=false and (title like #{str} or content like #{str}) ")
    @Results({
            @Result(property = "uuid",column = "uuid"),
            @Result(property = "userUuid",column = "user_uuid"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "content",column = "content"),
            @Result(property = "isMarrow",column = "is_marrow"),
            @Result(property = "title",column = "title"),
            @Result(property = "isTop",column = "is_top")
    })
    public List<Article> searchArticle(@Param("str") String str);

}