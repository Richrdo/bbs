package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Topic;

import java.util.List;

/**
 * @ClassName TopicService
 * @Author CeaserBorgia
 * @Date 11:35 2019/12/16
 * @Description
 */


public interface TopicService {

    /**
     * @Author:CeaserBorgia
     * @Date:19:20 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription: 获取未删除的所有贴子
     */
    List<Topic> getAllTopic();

    /**
     * @Author:CeaserBorgia
     * @Date:19:20 2019/12/17
     * @param:
     *  * @param topic
     *
     * @Desccription: 创建新的帖子
     */
    Long insertTopic(Topic topic);


    /**
     * @Author:CeaserBorgia
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param topic
     *
     * @Desccription: 更新帖子标题内容
     */
    int updateTopic(Topic topic);

    /**
     * @Author:CeaserBorgia
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param id
     *
     * @Desccription: 加精帖子
     */
    int marrowTopicByID(Long id);


    /**
     * @Author:CeaserBorgia
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription: 置顶帖子
     */
    int upTopicByID(Long id);


    /**
     * @Author:CeaserBorgia
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription:   删除帖子
     */
    int deleteTopicByID(Long id);

    /**
     * @Author:CeaserBorgia
     * @Date:19:38 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription: 通过ID获取帖子
     */
    Topic getTopicByID(Long id);
}

