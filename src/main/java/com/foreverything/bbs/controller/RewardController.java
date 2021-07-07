package com.foreverything.bbs.controller;

import com.foreverything.bbs.entities.Reward;
import com.foreverything.bbs.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RewardController
 * @Author Yanlan_Li
 * Date 21:59 2019/12/17
 * @Description
 */
@Controller
public class RewardController {
    @Autowired
    RewardService rewardService;

    //获取reward列表
    @GetMapping("/reward")
    public ModelAndView getReward(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("rewards", rewardService.getAllReward());
//        setViewName()用来设置跳转页面
       mv.setViewName("rewardPage");
        return mv;
    }

  //发布新悬赏
    @PostMapping("/add/reward")
    public String createNewReward(Reward reward, HttpServletRequest request, Model model){
        if (null==reward.getTitle()||null==reward.getContent()){
            model.addAttribute("message","信息不完整");
            return "newRewardPage";
        }else if(!rewardService.isEnough(reward.getPoints(), (String) request.getSession().getAttribute("userID"))) {
            model.addAttribute("message","您的积分不足");
            return "newRewardPage";//积分不够
        }else{
            String id=rewardService.insertReward(reward);
            if (id!=null){
                model.addAttribute("message","发布成功");
                return "redirect:/reward";
            }else{
                model.addAttribute("message","发布失败，请重新登录`");
                return "newRewardPage";
            }
        }
    }

    @PutMapping("/update/reward")
    public ModelAndView updateReward(Reward reward){
        ModelAndView mv=new ModelAndView();
        if (null==reward.getContent()||null==reward.getTitle()){
            mv.addObject("message","标题或内容为空！");

//            TODO 跳转到原修改帖子界面
        }else{
            if (rewardService.putReward(reward)>0){
                mv.addObject("message","修改成功");
               // mv.setViewName("RewardPage");//               TODO 跳转到讨悬赏页面

            }else{
                mv.addObject("message","修改失败！");

//                TODO 跳转到原修改帖子页面
            }
        }
        //mv.setViewName("rewardPage");
        return mv;
    }
}
