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

    Article getArticleByID(int id);

    int insertArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(int id);

    int cancelDeleteArticle(int id);

    int upArticleByID(int id);

    int cancelUpArticleByID(int id);

    int marrowArticleByID(int id);

    int cancelMarrowArticleByID(int id);
}
