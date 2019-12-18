package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Article;

import java.util.List;

/**
 * @ClassName RewardService
 * @Author ying_tie
 * Date 15:09 2019/12/16
 * @Description
 */
public interface ArticleService {
    List<Article> getAllArticle();
    Article getArticleByID(Long id);
    Long insertArticle(Article article);
    int updateArticle(Article article);
    int deleteArticle(Article article);
}
