package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Article;
import com.foreverything.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

    /**
     * @ClassName PartOne
     * @Author ying_tie
     * Date 14:52 2019/12/16
     * @Description
     */
    @RestController
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

        @PostMapping("/article")
        public ModelAndView createNewArticle(Article article){
            ModelAndView mv=new ModelAndView();

            if (null==article.getTitle()||null==article.getContent()){
                mv.addObject("msg","请填写完整");
//            TODO 跳转到原帖子界面
                //mv.setViewName("/articlePage1");
            }else{
                Long id=articleService.insertArticle(article);
                if (id>0){
                    mv.addObject("msg","发布成功");

                    mv.addObject("newArticle",articleService.getArticleByID(id));
//               TODO 跳转到文章区页面
                    //mv.setViewName("/articlePage");
                }else{
                    mv.addObject("msg","创建失败");
                    //            TODO 跳转到原帖子界面
                    //mv.setViewName("/articlePage1");
                }
            }
//        注意！！！！！！！！！！！！如果没写前端就测试的话，mv.setViewName()必须指向一个已经存在的template，否则会报错!!!!!!!!!
            mv.setViewName("articlePage");
            return mv;
        }

        @DeleteMapping("/article")
        public int deleteArticle(Long  id){
            return articleService.deleteArticle(id);
        }


        @PutMapping("/article")
        public ModelAndView updateArticle(Article article){
            ModelAndView mv=new ModelAndView();
            if (null==article.getContent()||null==article.getTitle()){
                mv.addObject("msg","标题或内容为空！");
//            TODO 跳转到原修改帖子界面
            }else{
                if (articleService.updateArticle(article)>0){
                    mv.addObject("msg","修改成功");
//                TODO 跳转到讨论区页面
                }else{
                    mv.addObject("msg","修改失败！");
//                TODO 跳转到原修改帖子页面
                }
            }
            mv.setViewName("articlePage");
            return mv;
        }
    }

