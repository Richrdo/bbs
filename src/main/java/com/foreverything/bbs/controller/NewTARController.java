package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String newArticle(Model model){
        model.addAttribute("msg","ok");
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

