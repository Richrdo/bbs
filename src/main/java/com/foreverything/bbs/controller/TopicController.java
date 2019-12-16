package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TopicController
 * @Author CeaserBorgia
 * @Date 11:32 2019/12/16
 * @Description
 */

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping("/getAllTopic")
    public List<Topic> getTopic(){
        return topicService.getAllTopic();
    }


}

