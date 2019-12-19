package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.mapper.ArticleMapper;
import com.foreverything.bbs.mapper.ReplayMapper;
import com.foreverything.bbs.mapper.RewardMapper;
import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SearchServiceImpl
 * @Author 刘光辉
 * @Date 15:29  2019/12/19
 * @Description
 */

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ReplayMapper replayMapper;

    @Autowired
    RewardMapper rewardMapper;

    @Override
    public List<Topic> searchTopic(String str) {
        return topicMapper.searchTopic(str);
    }

    @Override
    public List<Article> searchArticle(String str) {
        return articleMapper.searchArticle(str);
    }

    @Override
    public List<Reward> searchReward(String str) {
        return rewardMapper.searchReward(str);
    }

    @Override
    public List<Replay> searchReplay(String str) {
        return replayMapper.searchReplay(str);
    }
}

