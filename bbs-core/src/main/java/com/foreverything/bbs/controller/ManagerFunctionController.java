package com.foreverything.bbs.controller;


import com.foreverything.bbs.service.ArticleService;
import com.foreverything.bbs.service.ReplayService;
import com.foreverything.bbs.service.RewardService;
import com.foreverything.bbs.service.TopicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ManagerFunctionController
 * @Author 刘光辉
 * @Date 8:02  2019/12/20
 * @Description
 */

@Controller
public class ManagerFunctionController {
    
    @Autowired
    ArticleService articleService;
    
    @Autowired
    ReplayService replayService;
    
    @Autowired
    RewardService rewardService;
    
    @Autowired
    TopicService topicService;

    @RequestMapping("/up/article")
    public String upArticle(@Param("id")String id, HttpServletRequest request){
        articleService.upArticleByID(id);
        System.out.println("置顶的帖子为+"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/up/topic")
    public String upTopic(@Param("id")String id,HttpServletRequest request){
        topicService.upTopicByID(id);
        System.out.println("置顶的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/delete/article")
    public String deleteArticle(@Param("id")String id ,HttpServletRequest request){
        articleService.deleteArticle(id);
        System.out.println("删除的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/delete/topic")
    public String deleteTopic(@Param("id")String id,HttpServletRequest request){
        topicService.deleteTopicByID(id);
        System.out.println("删除的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/delete/replay")
    public String deleteReplay(@Param("id")String id,HttpServletRequest request){
        replayService.deleteReplay(id);
        System.out.println("删除的回复为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/delete/reward")
    public String deleteReward(@Param("id")String id,HttpServletRequest request){
        rewardService.deleteReward(id);
        System.out.println("删除的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/cancelup/topic")
    public String cancelUpTopic(@Param("id")String id,HttpServletRequest request){
        topicService.cancelUpTopicByID(id);
        System.out.println("取消置顶的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/cancelup/article")
    public String cancelUpArticle(@Param("id")String id,HttpServletRequest request){
        articleService.cancelUpArticleByID(id);
        System.out.println("取消置顶的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/marrow/article")
    public String marrowArticle(@Param("id")String id,HttpServletRequest request){
        articleService.marrowArticleByID(id);
        System.out.println("加精的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/marrow/topic")
    public String marrowTopic(@Param("id")String id,HttpServletRequest request){
        topicService.marrowTopicByID(id);
        System.out.println("加精的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/cancelmarrow/topic")
    public String cancelMarrowTopic(String id,HttpServletRequest request){
        topicService.cancelMarrowTopicByID(id);
        System.out.println("取消加精的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

    @RequestMapping("/cancelmarrow/article")
    public String cancelMarrowArtic(String id,HttpServletRequest request){
        articleService.cancelMarrowArticleByID(id);
        System.out.println("取消加精的帖子为"+id);
        return "redirect:/search?str="+request.getSession().getAttribute("searchStr");
    }

}

