package com.foreverything.bbs.config;

import com.foreverything.bbs.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName PurviewConfigurer
 * @Author 刘光辉
 * @Date 17:06  2019/12/19
 * @Description
 */

@Configuration
public class PurviewConfigurer implements WebMvcConfigurer{

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor).addPathPatterns("/add/**","/new/**","/delete/**","/update/**","/up/**","/marrow/**","/topicDetail","/articleDetail","/rewardDetail");
    }
}

