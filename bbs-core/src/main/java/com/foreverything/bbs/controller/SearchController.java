package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.entities.User_old;
import com.foreverything.bbs.service.SearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/search",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView search(@Param("str") String str, HttpServletRequest request){
        request.getSession().setAttribute("searchStr",str);

        str="%"+str+"%";
        mv=new ModelAndView();
        String roleName = request.getSession().getAttribute("roleName").toString();
        if (roleName !=null&& roleName.equals("admin")){
            System.out.println("success");
            mv.addObject("isAdmin",true);
        }else{
            mv.addObject("isAdmin",false);
        }

        mv.addObject("articleList",searchService.searchArticle(str));
        mv.addObject("replayList",searchService.searchReplay(str));
        mv.addObject("rewardList",searchService.searchReward(str));
        mv.addObject("topicList",searchService.searchTopic(str));
        mv.setViewName("searchPage");

        return mv;
    }


}

