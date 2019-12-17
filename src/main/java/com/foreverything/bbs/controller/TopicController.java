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
//        setViewName()用来设置跳转页面
        mv.setViewName("topicPage");
        return mv;
    }

    @PostMapping("/topic")
    public ModelAndView createNewTopic(Topic topic){
        ModelAndView mv=new ModelAndView();

        if (null==topic.getTitle()||null==topic.getContent()){
            mv.addObject("msg","请填写完整");
//            TODO 跳转到原帖子界面
        }else{
            Long id=topicService.insertTopic(topic);
            if (id>0){
                mv.addObject("msg","发布成功");

                mv.addObject("newTopic",topicService.getTopicByID(id));
//               TODO 跳转到讨论区页面
            }else{
                mv.addObject("msg","创建失败");
                //            TODO 跳转到原帖子界面
            }
        }
//        注意！！！！！！！！！！！！如果没写前端就测试的话，mv.setViewName()必须指向一个已经存在的template，否则会报错!!!!!!!!!
        mv.setViewName("topicPage");
        return mv;
    }

    @PutMapping("/topic")
    public ModelAndView updateTopic(Topic topic){
        ModelAndView mv=new ModelAndView();
        if (null==topic.getContent()||null==topic.getTitle()){
            mv.addObject("msg","标题或内容为空！");
//            TODO 跳转到原修改帖子界面
        }else{
            if (topicService.updateTopic(topic)>0){
                mv.addObject("msg","修改成功");
//                TODO 跳转到讨论区页面
            }else{
                mv.addObject("msg","修改失败！");
//                TODO 跳转到原修改帖子页面
            }
        }
        mv.setViewName("topicPage");
        return mv;
    }
}

