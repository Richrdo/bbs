package com.foreverything.bbs.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    //    队列bean的名称， email用来发邮件
    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";

//     交换机名称
    public static final String EXCHANGE_TOPIC_INFORM = "exchange_topic_inform";




}
