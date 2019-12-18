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
    @Select("select * from article where a_is_delete=false")
    @Results({
            @Result(property = "id", column = "a_id", id = true),
            @Result(property = "userID", column = "a_author_id"),
            @Result(property = "title", column = "a_title"),
            @Result(property = "content", column = "a_content"),
            @Result(property = "createTime", column = "a_create_time"),
            @Result(property = "isMarrow", column = "a_is_marrow"),
            @Result(property = "isDelete", column = "a_is_delete")
    })
    abstract List<Article> getAllArticle();

    @Select("select * from article where a_id=#{id}")
    @Results({
            @Result(property = "id", column = "a_id", id = true),
            @Result(property = "userID", column = "a_author_id"),
            @Result(property = "title", column = "a_title"),
            @Result(property = "content", column = "a_content"),
            @Result(property = "createTime", column = "a_create_time"),
            @Result(property = "isMarrow", column = "a_is_marrow"),
            @Result(property = "isDelete", column = "a_is_delete")
    })
    Article getArticleByID(@Param("id")Long id);

    @Insert("insert into article(a_id,a_author_id,a_title,a_content,a_create_time) values(#{article.id},#{article.userID},#{article.title},#{article.content},#{article.createTime})")
    public Long insertArticle(@Param("article") Article article);

    @Select("select a_id from article")//查找所有文章id
    public List<Long> getArticleIdCollection();

    @Update("update article set a_title=#{article.title},a_content=#{article.content} where a_id=#{article.id}")
    public int updateArticle(@Param("article")Article article);

    @Update("update article set a_is_delete=true where id=#{id}")
    public int deleteArticleByID(@Param("id")Long id);

    @Update("update article set a_is_top=false where id=#{id}")
    public int cancelUpArticleByID(@Param("id")Long id);

    @Update("update article set a_is_top=true where id=#{id}")
    public int upArticle(@Param("id")Long id);

    @Update("update article set a_is_marrow=true where id=#{id}")
    public int marrowArticleByID(@Param("id")Long id);

    @Update("update article set a_is_marrow=false where id=#{id}")
    public int cancelMarrowArticleByID(@Param("id")Long id);
}