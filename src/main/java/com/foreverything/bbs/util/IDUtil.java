package com.foreverything.bbs.util;

import com.foreverything.bbs.mapper.ArticleMapper;
import com.foreverything.bbs.mapper.ReplayMapper;
import com.foreverything.bbs.mapper.RewardMapper;
import com.foreverything.bbs.mapper.TopicMapper;
import com.foreverything.bbs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName IDUtil
 * @Author CeaserBorgia
 * @Date 19:11 2019/12/16
 * @Description
 */

@Component
public class IDUtil {

    private static IDUtil idUtil;


    private static List<Long> rewardIDList=new ArrayList<>();
    private static List<Long> topicIDList=new ArrayList<>();
    private static List<Long> replayIDList=new ArrayList<>();
    private static List<Integer> userIDList=new ArrayList<>();
    private static List<Long>  articleIDList=new ArrayList<>();

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    RewardMapper rewardMapper;

    @Autowired
    ReplayMapper replayMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleMapper articleMapper;

    @PostConstruct
    public void init(){
        /**
         * @Author:CeaserBorgia
         * @Date:19:19 2019/12/16
         * @param:
         *  * @param
         *
         * @Desccription: 工具类在静态方法中引用mapper接口需调用该方法，否则报空指针
         *
         */
        idUtil=this;
        idUtil.topicMapper=this.topicMapper; //装配Mapper后给储存topicID的List赋值
        idUtil.rewardMapper=this.rewardMapper;
        idUtil.replayMapper=this.replayMapper;
        idUtil.userMapper=this.userMapper;
        idUtil.articleMapper=this.articleMapper;

        userIDList=userMapper.getUserIdCollection();
        replayIDList=replayMapper.getReplayIDList();
        topicIDList=topicMapper.getTopicIdCollection();
        rewardIDList=rewardMapper.getRewardIdCollection();
        articleIDList=articleMapper.getArticleIdCollection();
    }

    public static Long initID(){
        /**
         * @Author:CeaserBorgia
         * @Date:23:08 2019/12/16
         * @param:
         *  * @param
         *
         * @Desccription: 生成不重复的12位ID
         */

        Long id;
        id=randomALongID();

        while(topicIDList.contains(id)||replayIDList.contains(id)||rewardIDList.contains(id)||articleIDList.contains(id)){

            id=randomALongID();
        }
        return id;
    }

    private static Long randomALongID(){
        /**
         * @Author: CeaserBorgia
         * @Date: 19:25 2019/12/16
         * @param:
         *  * @param
         *
         * @Desccription: 生成12位的随机数，并不校验重复
         */
        Random random=new Random();
        long id=Math.abs(random.nextLong())%(1000000000000L);
        if(id<1e11){
            id+=1e11;
        }
        return id;
    }

    private static int randomIntegerID(){
        /**
         * @Author:CeaserBorgia
         * @Date:19:46 2019/12/18
         * @param:
         *  * @param
         *
         * @Desccription:
         */

        Random random=new Random();
        int id=Math.abs(random.nextInt())%(1000000);
        if(id<100000){
            id+=100000;
        }
        return id;
    }

    public static int initUserID(){
        /**
         * @Author:CeaserBorgia
         * @Date:19:50 2019/12/18
         * @param:
         *  * @param
         *
         * @Desccription: 生成6位userID
         */

        int id;
        id=randomIntegerID();
        while (userIDList.contains(id)){
            id=randomIntegerID();
        }
        return id;
    }

}

