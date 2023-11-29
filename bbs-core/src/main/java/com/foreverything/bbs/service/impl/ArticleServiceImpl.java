package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.mapper.ArticleMapper;
import com.foreverything.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName ArticleServiceImpl
 * @Author ying_tie
 * Date 17:13 2019/12/18
 * @Description
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticle() {
        return articleMapper.getAllArticle();
    }

    @Override
    public int insertArticle(Article article) {

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        article.setCreateTime(dateFormat.format(date));
        if (articleMapper.insertArticle(article) > 0) {
            article.setId(articleMapper.getContentId());
            return article.getId();
        }
        return -1;
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(int id) {
        return articleMapper.deleteArticleByID(id);
    }

    @Override
    public int cancelDeleteArticle(int id) {
        return articleMapper.cancelMarrowArticleByID(id);
    }

    @Override
    public int upArticleByID(int id) {
        return articleMapper.upArticle(id);
    }

    @Override
    public int cancelUpArticleByID(int id) {
        System.out.println("开始撤回article: " + id);
        return articleMapper.cancelUpArticleByID(id);
    }

    @Override
    public int marrowArticleByID(int id) {
        return articleMapper.marrowArticleByID(id);
    }

    @Override
    public int cancelMarrowArticleByID(int id) {
        return articleMapper.cancelMarrowArticleByID(id);
    }

    @Override
    public Article getArticleByID(int id) {
        return articleMapper.getArticleByID(id);
    }

}

