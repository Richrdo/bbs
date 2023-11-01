package com.timegoesby.captcha.utils;

import io.micrometer.core.instrument.util.NamedThreadFactory;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EmailThreadPool {
    static final int EMAIL_CORE_POOL_SIZE = 10;
    static final int EMAIL_MAXIMUM_POOL_SIZE = 20;
    static final int MAX_QUEUE_NUM = 1024;
    static final long KEEP_ALIVE_TIME = 1L;
    static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private volatile static ExecutorService executorService = new ThreadPoolExecutor(
            EMAIL_CORE_POOL_SIZE, EMAIL_MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT,
            new LinkedBlockingDeque<>(MAX_QUEUE_NUM),
            new NamedThreadFactory("EmailThreadExecutorFactory-"),
            new ThreadPoolExecutor.AbortPolicy()
    );

    private EmailThreadPool() {
    }

    public static ExecutorService getInstance() {
        return executorService;
    }

}
