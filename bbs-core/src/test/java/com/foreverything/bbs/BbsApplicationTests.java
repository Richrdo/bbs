package com.foreverything.bbs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.annotation.security.RunAs;


@SpringBootTest(classes = BbsApplication.class)
class BbsApplicationTests {



    @Test
    void contextLoads() {
        System.out.println();
    }

}
