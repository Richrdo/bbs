package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.entities.Topic;
import com.foreverything.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

    /**
 * @ClassName PartOne
 * @Author ying_tie
 * Date 14:52 2019/12/16
 * @Description
 */
    @Controller
    public class ArticleController {

        @Autowired
        ArticleService articleService;

        @GetMapping("/article")
        public ModelAndView getArticle(){
            ModelAndView mv = new ModelAndView();
            mv.addObject("articles", articleService.getAllArticle());
//        setViewName()用来设置跳转页面
            mv.setViewName("articlePage");
            return mv;
        }

        @PostMapping("/add/article")
        public String createNewArticle(Article article,Model model,HttpServletRequest request){
            if (article.getTitle().length()==0||0==article.getContent().length()){
                model.addAttribute("message","内容不完整");
                return "newArticlePage";
            }else{
                article.setUserID((Integer) request.getSession().getAttribute("userID"));
                Long id=articleService.insertArticle(article);
                if (id>0){
                    return "redirect:/article";
                }else{
                    model.addAttribute("message","发布失败，请重试");
                    return "newArticlePage";
                }
            }

        }

        @DeleteMapping("/delete/article")
        public int deleteArticle(Long  id){
            return articleService.deleteArticle(id);
        }


        @PutMapping("/update/article")
        public ModelAndView updateArticle(Article article){
            ModelAndView mv=new ModelAndView();
            if (null==article.getContent()||null==article.getTitle()){
                mv.addObject("message","标题或内容为空！");
//            TODO 跳转到原修改帖子界面
            }else{
                if (articleService.updateArticle(article)>0){
                    mv.addObject("message","修改成功");
//                TODO 跳转到讨论区页面
                }else{
                    mv.addObject("message","修改失败！");
//                TODO 跳转到原修改帖子页面
                }
            }
            mv.setViewName("articlePage");
            return mv;
        }
    }

