package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.mapper.ArticleMapper;
import com.foreverything.bbs.service.ArticleService;
import com.foreverything.bbs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Author ying_tie
 * Date 17:13 2019/12/18
 * @Description
 */
@Service
public class ArticleServiceImpl implements ArticleService{

        @Autowired
        ArticleMapper articleMapper;

        @Override
        public List<Article> getAllArticle() {
            return articleMapper.getAllArticle();
        }

        @Override
        public Long insertArticle(Article article){
            article.setId(IDUtil.initID());

            SimpleDateFormat dateFormat=new SimpleDateFormat();
            dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
            Date date=new Date();

            article.setCreateTime(dateFormat.format(date));

            if (articleMapper.insertArticle(article)>0){
                return article.getId();
            }else
                return 0L;
        }
        @Override
        public int updateArticle(Article article) {
            return articleMapper.updateArticle(article);
        }
        @Override
        public int deleteArticle(Long id){
            return articleMapper.deleteArticleByID(id);
        }

    @Override
    public int upArticleByID(Long id) {
        return articleMapper.upArticle(id);
    }

    @Override
    public int cancelUpArticleByID(Long id) {
        return articleMapper.cancelUpArticleByID(id);
    }

    @Override
    public int marrowArticleByID(Long id) {
        return articleMapper.marrowArticleByID(id);
    }

    @Override
    public int cancelMarrowArticleByID(Long id) {
        return articleMapper.cancelMarrowArticleByID(id);
    }

    @Override
    public Article getArticleByID(Long id) {
            return articleMapper.getArticleByID(id);
        }

}

