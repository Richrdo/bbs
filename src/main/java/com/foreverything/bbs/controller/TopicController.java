package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TopicController
 * @Author 刘光辉
 * @Date 11:32 2019/12/16
 * @Description
 */

@Controller
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/topic")
    public ModelAndView getTopic(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("topics", topicService.getAllTopic());
        mv.setViewName("topicPage");
        return mv;
    }

    @PostMapping("/add/topic")
    public String createNewTopic(Topic topic,HttpServletRequest request){

        if (null==topic.getTitle()||null==topic.getContent()){
//            失败跳转，不同区域把topic改成自己区域的名称就行
            return "redirect:/new/topic";
        }else{
            topic.setUserUuid((String) request.getSession().getAttribute("userID"));
            String id=topicService.insertTopic(topic);
            if (id!=null){
//                成功跳转，同样只改topic
                return "redirect:/topic";
            }else{
                //            失败跳转，不同区域把topic改成自己区域的名称就行
                return "redirect:/new/topic";
            }
        }
    }

    @PutMapping("/add/topic")
    public ModelAndView updateTopic(Topic topic){
        ModelAndView mv=new ModelAndView();
        if (null==topic.getContent()||null==topic.getTitle()){
            mv.addObject("message","标题或内容为空！");
//            TODO 跳转到原修改帖子界面
        }else{
            if (topicService.updateTopic(topic)>0){
                mv.addObject("message","修改成功");
//                TODO 跳转到讨论区页面
            }else{
                mv.addObject("message","修改失败！");
//                TODO 跳转到原修改帖子页面
            }
        }
        mv.setViewName("topicPage");
        return mv;
    }
}

