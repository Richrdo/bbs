package com.foreverything.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName NewTARController
 * @Author 刘光辉
 * @Date 21:30  2019/12/18
 * @Description
 */

@Controller
@RequestMapping("/new")
public class NewTARController {

    @RequestMapping("/article")
    public String newArticle(){
        return "newArticlePage";
    }

    @RequestMapping("/topic")
    public String newTopic(){
        return "newTopicPage";
    }

    @RequestMapping("/reward")
    public String newReward(){
        return "newRewardPage";
    }

    @RequestMapping("/index")
    public String goIndex(){
        return "index";
    }

}

