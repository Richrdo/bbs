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
    public String insertArticle(Article article) {

        article.setUuid(UUID.randomUUID().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        article.setCreateTime(dateFormat.format(date));
        if (articleMapper.insertArticle(article) > 0) {
            return article.getUuid();
        } else
            return null;
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(String id) {
        return articleMapper.deleteArticleByID(id);
    }

    @Override
    public int cancelDeleteArticle(String id) {
        return articleMapper.cancelMarrowArticleByID(id);
    }

    @Override
    public int upArticleByID(String id) {
        return articleMapper.upArticle(id);
    }

    @Override
    public int cancelUpArticleByID(String id) {
        System.out.println("开始撤回article: "+id);
        return articleMapper.cancelUpArticleByID(id);
    }

    @Override
    public int marrowArticleByID(String id) {
        return articleMapper.marrowArticleByID(id);
    }

    @Override
    public int cancelMarrowArticleByID(String id) {
        return articleMapper.cancelMarrowArticleByID(id);
    }

    @Override
    public Article getArticleByID(String id) {
        return articleMapper.getArticleByID(id);
    }

}

