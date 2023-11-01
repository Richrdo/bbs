package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName TopicServiceImpl
 * @Author 刘光辉
 * @Date 11:37 2019/12/16
 * @Description
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public List<Topic> getAllTopic() {
        return topicMapper.getAllTopic();
    }

    @Override
    public String insertTopic(Topic topic) {

        topic.setUuid(UUID.randomUUID().toString());

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();

        topic.setCreateTime(dateFormat.format(date));

        if (topicMapper.insertTopic(topic)>0){
            return topic.getUuid();
        }else
        return null;
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public int marrowTopicByID(String id) {
        return topicMapper.marrowTopicByID(id);
    }

    @Override
    public int cancelMarrowTopic(String id) {
        return topicMapper.cancelMarrowTopicByID(id);
    }

    @Override
    public int upTopicByID(String id) {
        return topicMapper.upTopicByID(id);
    }

    @Override
    public int deleteTopicByID(String id) {
        return topicMapper.deleteTopicByID(id);
    }

    @Override
    public int cancelDeleteTopicByID(String id) {
        return cancelDeleteTopicByID(id);
    }

    @Override
    public Topic getTopicByID(String id) {
        return topicMapper.getTopicByID(id);
    }

    @Override
    public int cancelUpTopicByID(String id) {
        return topicMapper.cancelUpTopicByID(id);
    }

    @Override
    public int cancelMarrowTopicByID(String id) {
        return topicMapper.cancelMarrowTopicByID(id);
    }


}

