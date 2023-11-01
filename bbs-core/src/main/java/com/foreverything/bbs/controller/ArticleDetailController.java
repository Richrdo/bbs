package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.service.ReplayService;
import com.foreverything.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName ArticleDetailController
 * @Author ying_tie
 * Date 17:19 2019/12/18
 * @Description
 */
@Controller
public class ArticleDetailController {
    @Autowired
    ReplayService replayService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/articleDetail")
    public ModelAndView getArticleDetail(@RequestParam(value = "id") String id){
        ModelAndView mv=new ModelAndView();
        Article article = articleService.getArticleByID(id);
        System.out.println("点击的article："+article);
        mv.addObject("obj",article);
        List<Replay> replayList=replayService.getReplayListByID(id);
        System.out.println("该文章的评论有"+replayList.toString());
        mv.addObject("replays",replayList);
        mv.setViewName("articleDetailPage");
        return mv;
    }
}
