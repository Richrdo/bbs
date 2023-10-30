package com.foreverything.bbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","com.foreverything.bbs.mapper"})
@ComponentScan({"com.gitee.sunchenbin.mybatis.actable.manager.*","com.foreverything.bbs.*"})
@EnableFeignClients(basePackages = "com.foreverything.bbs.feign")
public class BbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }

}
