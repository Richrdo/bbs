package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.ReplayService;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @ClassName TopicDetailController
 * @Author 刘光辉
 * @Date 23:31  2019/12/17
 * @Description
 */

@Controller
public class TopicDetailController {

    @Autowired
    ReplayService replayService;

    @Autowired
    TopicService topicService;

    @GetMapping("/topicDetail")
    public ModelAndView getTopicDetail(@RequestParam(value = "id") String id){
        ModelAndView mv=new ModelAndView();
        Topic topic = topicService.getTopicByID(id);
        System.out.println("点击的topic："+topic);
        mv.addObject("obj",topic);
        List<Replay> replayList=replayService.getReplayListByID(id);
        mv.addObject("replays",replayList);
        mv.setViewName("topicDetailPage");
        return mv;
    }

}

