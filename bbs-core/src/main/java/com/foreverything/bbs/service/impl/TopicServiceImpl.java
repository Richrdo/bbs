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
    public int insertTopic(Topic topic) {

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();

        topic.setCreateTime(dateFormat.format(date));

        if (topicMapper.insertTopic(topic)>0){
            topic.setId(topicMapper.getContentId());
            return topic.getId();
        }
        return -1;
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public int marrowTopicByID(int id) {
        return topicMapper.marrowTopicByID(id);
    }

    @Override
    public int cancelMarrowTopic(int id) {
        return topicMapper.cancelMarrowTopicByID(id);
    }

    @Override
    public int upTopicByID(int id) {
        return topicMapper.upTopicByID(id);
    }

    @Override
    public int deleteTopicByID(int id) {
        return topicMapper.deleteTopicByID(id);
    }

    @Override
    public int cancelDeleteTopicByID(int id) {
        return cancelDeleteTopicByID(id);
    }

    @Override
    public Topic getTopicByID(int id) {
        return topicMapper.getTopicByID(id);
    }

    @Override
    public int cancelUpTopicByID(int id) {
        return topicMapper.cancelUpTopicByID(id);
    }

    @Override
    public int cancelMarrowTopicByID(int id) {
        return topicMapper.cancelMarrowTopicByID(id);
    }


}

