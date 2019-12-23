package com.foreverything.bbs.config.interceptors;

import com.foreverything.bbs.entities.User;
import com.foreverything.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginInterceptor
 * @Author 刘光辉
 * @Date 16:50  2019/12/19
 * @Description
 */

@Service
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws  Exception{
        HttpSession session=request.getSession();
        if (session.getAttribute("idToNameMap")==null){
            session.setAttribute("idToNameMap",userService.getUserMap());
        }
        if (null==session.getAttribute("userID")){
            response.sendRedirect("/login");
            return false;
        }else{
            System.out.println("更新积分");
            session.setAttribute("userPoints",userService.getUserPoints((Integer)session.getAttribute("userID")));
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}

