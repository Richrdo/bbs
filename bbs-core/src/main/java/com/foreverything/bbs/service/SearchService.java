package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.entities.Topic;

import java.util.List;

/**
 * @ClassName SearchService
 * @Author 刘光辉
 * @Date 15:14  2019/12/19
 * @Description
 */

public interface SearchService {

    /**
     * @Author:CeaserBorgia
     * @Date:15:48 2019/12/19
     * @param:
     *  * @param null
     *
     * @Desccription: 搜索讨论
     */
    List<Topic> searchTopic(String str);

    /**
     * @Author:CeaserBorgia
     * @Date:15:49 2019/12/19
     * @param:
     *  * @param null
     *
     * @Desccription: 搜索文章
     */
    List<Article> searchArticle(String str);

    /**
     * @Author:CeaserBorgia
     * @Date:15:49 2019/12/19
     * @param:
     *  * @param null
     *
     * @Desccription: 搜索悬赏
     */
    List<Reward> searchReward(String str);

    /**
     * @Author:CeaserBorgia
     * @Date:15:49 2019/12/19
     * @param:
     *  * @param null
     *
     * @Desccription: 搜索回复
     */
    List<Replay> searchReplay(String str);

}

