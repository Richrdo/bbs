package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.TopicService;
import com.foreverything.bbs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Author CeaserBorgia
 * @Date 11:37 2019/12/16
 * @Description
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public List<Topic> getAllTopic() {
        /**
         * @Author:CeaserBorgia
         * @Date:17:33 2019/12/16
         * @param:
         *  * @param
         *
         * @Desccription:
         */
        return topicMapper.getAllTopic();
    }

    @Override
    public int insertTopic(Topic topic) {
        /**
         * @Author:CeaserBorgia
         * @Date:17:33 2019/12/16
         * @param:
         *  * @param topic
         *
         * @Desccription: 新建帖子
         */

        topic.setId(IDUtil.initTopicID());
        return topicMapper.insertTopic(topic);
    }



}

