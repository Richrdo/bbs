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

    int deleteArticle(Long id);

    int upArticleByID(Long id);

    int cancelUpArticleByID(Long id);

    int marrowArticleByID(Long id);

    int cancelMarrowArticleByID(Long id);
}
