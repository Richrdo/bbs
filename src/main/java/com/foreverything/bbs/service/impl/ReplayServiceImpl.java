package com.foreverything.bbs.service.impl;

import com.foreverything.bbs.entities.Replay;
import com.foreverything.bbs.mapper.ReplayMapper;
import com.foreverything.bbs.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName ReplayServiceImpl
 * @Author 刘光辉
 * @Date 23:51  2019/12/17
 * @Description
 */

@Service
public class ReplayServiceImpl implements ReplayService {

    @Autowired
    ReplayMapper replayMapper;

    @Override
    public List<Replay> getReplayListByID(String id) {
        return replayMapper.getReplayListByFromID(id);
    }

    @Override
    public String insertReplay(Replay replay) {
        replay.setUuid(UUID.randomUUID().toString());

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();

        replay.setCreateTime(dateFormat.format(date));
        if (replayMapper.insertReplay(replay)>0){
            return  replay.getUuid();
        }else
        return null;
    }

    @Override
    public int deleteReplay(String id) {
        return replayMapper.deleteReplay(id);
    }

    @Override
    public int cancelDeleteReplay(String id) {
        return replayMapper.cancelDeleteReplay(id);
    }

}

