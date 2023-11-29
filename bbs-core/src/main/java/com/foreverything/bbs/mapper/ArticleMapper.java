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
            @Result(property = "id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "isMarrow", column = "is_marrow"),
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "isTop",column = "is_top")
    })
    abstract List<Article> getAllArticle();

    @Select("select * from article where uuid=#{uuid}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "isMarrow", column = "is_marrow"),
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "isTop",column = "is_top")
    })
    Article getArticleByID(@Param("id")int id);

    @Select("SELECT LAST_INSERT_ID()")
    public int getContentId();

    @Insert("insert into article(user_id,title,content,create_time) values(#{article.userId},#{article.title},#{article.content},#{article.createTime})")
    public int insertArticle(@Param("article") Article article);


    @Update("update article set title=#{article.title},content=#{article.content} where id=#{article.id}")
    public int updateArticle(@Param("article")Article article);

    @Update("update article set is_delete=true where id=#{id}")
    public int deleteArticleByID(@Param("id")int id);

    @Update("update article set is_top=false where id=#{id}")
    public int cancelUpArticleByID(@Param("id")int id);

    @Update("update article set is_top=true where id=#{id}")
    public int upArticle(@Param("id")int id);

    @Update("update article set is_marrow=true where id=#{id}")
    public int marrowArticleByID(@Param("id")int id);

    @Update("update article set is_marrow=false where id=#{id}")
    public int cancelMarrowArticleByID(@Param("id")int id);

    @Select("select * from article where is_delete=false and (title like #{str} or content like #{str}) ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "isMarrow", column = "is_marrow"),
            @Result(property = "isDelete", column = "is_delete"),
            @Result(property = "isTop",column = "is_top")
    })
    public List<Article> searchArticle(@Param("str") String str);

}