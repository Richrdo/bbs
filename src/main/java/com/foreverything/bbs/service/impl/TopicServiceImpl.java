package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.TopicService;
import com.foreverything.bbs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return topicMapper.getAllTopic();
    }

    @Override
    public Long insertTopic(Topic topic) {

        topic.setId(IDUtil.initID());

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();

        topic.setCreateTime(dateFormat.format(date));

        if (topicMapper.insertTopic(topic)>0){
            return topic.getId();
        }else
        return 0L;
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public int marrowTopicByID(Long id) {
        return topicMapper.marrowTopicByID(id);
    }

    @Override
    public int upTopicByID(Long id) {
        return topicMapper.upTopicByID(id);
    }

    @Override
    public int deleteTopicByID(Long id) {
        return topicMapper.deleteTopicByID(id);
    }

    @Override
    public Topic getTopicByID(Long id) {
        return topicMapper.getTopicByID(id);
    }


}

