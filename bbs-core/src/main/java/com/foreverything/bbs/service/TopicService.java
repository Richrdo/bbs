package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Topic;

import java.util.List;

/**
 * @ClassName TopicService
 * @Author 刘光辉
 * @Date 11:35 2019/12/16
 * @Description
 */


public interface TopicService {

    /**
     * @Author:刘光辉
     * @Date:19:20 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription: 获取未删除的所有贴子
     */
    List<Topic> getAllTopic();

    /**
     * @Author:刘光辉
     * @Date:19:20 2019/12/17
     * @param:
     *  * @param topic
     *
     * @Desccription: 创建新的帖子
     */
    int insertTopic(Topic topic);


    /**
     * @Author:刘光辉
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param topic
     *
     * @Desccription: 更新帖子标题内容
     */
    int updateTopic(Topic topic);

    /**
     * @Author:刘光辉
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param id
     *
     * @Desccription: 加精帖子
     */
    int marrowTopicByID(int id);

    /**
     * @Author:CeaserBorgia
     * @Date:10:08 2019/12/20
     * @param:
     *  * @param null
     *
     * @Desccription:   取消加精
     */
    int cancelMarrowTopic(int id);

    /**
     * @Author:刘光辉
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription: 置顶帖子
     */
    int upTopicByID(int id);


    /**
     * @Author:刘光辉
     * @Date:19:21 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription:   删除帖子
     */
    int deleteTopicByID(int id);

    /**
     * @Author:CeaserBorgia
     * @Date:10:01 2019/12/20
     * @param:
     *  * @param null
     *
     * @Desccription:   取消删除帖子
     */
    int cancelDeleteTopicByID(int id);

    /**
     * @Author:刘光辉
     * @Date:19:38 2019/12/17
     * @param:
     *  * @param null
     *
     * @Desccription: 通过ID获取帖子
     */
    Topic getTopicByID(int id);

    /**
     * @Author:刘光辉
     * @Date:19:37 2019/12/18
     * @param:
     *  * @param null
     *
     * @Desccription: 取消置顶帖子
     */
    int cancelUpTopicByID(int id);

    /**
     * @Author:刘光辉
     * @Date:19:37 2019/12/18
     * @param:
     *  * @param null
     *
     * @Desccription: 取消置顶
     */
    int cancelMarrowTopicByID(int id);
}

