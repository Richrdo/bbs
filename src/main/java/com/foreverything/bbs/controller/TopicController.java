package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TopicController
 * @Author 刘光辉
 * @Date 11:32 2019/12/16
 * @Description
 */

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/topic")
    public List<Topic> getTopic(){
        return topicService.getAllTopic();
    }

    @PostMapping("/topic")
    public int createNewTopic(Topic topic){
        return topicService.insertTopic(topic);
    }
}

