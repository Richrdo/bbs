package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.ReplayService;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ReplayController
 * @Author 刘光辉
 * @Date 10:48  2019/12/18
 * @Description
 */

@Controller
public class ReplayController {
    @Autowired
    ReplayService replayService;
    @Autowired
    TopicService topicService;

    @PostMapping("/add/replay")
    public String replaySomething( HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        Replay replay=new Replay();
        String fromID=String.valueOf(request.getParameter("id"));
        replay.setFromId(fromID);
        replay.setContent(request.getParameter("content"));
        replay.setUserUuid((String) request.getSession().getAttribute("userID"));
        System.out.println("获取的评论为："+replay);
        String id=replayService.insertReplay(replay);
        if (id!=null){
            System.out.println("插入成功");
            Topic topic=topicService.getTopicByID(fromID);
            mv.addObject("obj",topic);
            System.out.println("插入的topic为"+topic);
            mv.addObject("message","发表成功");
        }else{
            mv.addObject("message","发表失败");
        }
        String path=request.getParameter("path_s");
        System.out.println("跳转的path为"+path);
        mv.setViewName("topicDetailPage");

        return "redirect:/"+path+"?id="+fromID;
    }
}

