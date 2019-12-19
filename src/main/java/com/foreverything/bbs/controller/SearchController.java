package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.service.SearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SearchController
 * @Author 刘光辉
 * @Date 14:37  2019/12/19
 * @Description
 */

@Controller
public class SearchController {
    ModelAndView mv;

    @Autowired
    SearchService searchService;

    @PostMapping("/search")
    public ModelAndView search(@Param("str") String str, HttpServletRequest request){
        str="%"+str+"%";
        mv=new ModelAndView();
        User user= (User) request.getSession().getAttribute("user");
        if (user!=null){
            mv.addObject("isAdmin",true);
        }else{
            mv.addObject("isAdmin",false);
        }
        mv=new ModelAndView();

        mv.addObject("articleList",searchService.searchArticle(str));
        mv.addObject("replayList",searchService.searchReplay(str));
        mv.addObject("rewardList",searchService.searchReward(str));
        mv.addObject("topicList",searchService.searchTopic(str));
        mv.setViewName("searchPage");

        return mv;
    }


}

