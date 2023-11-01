package com.foreverything.bbs.service;

import com.foreverything.bbs.entities.Replay;

import java.util.List;

/**
 * @ClassName ReplayService
 * @Author 刘光辉
 * @Date 23:40  2019/12/17
 * @Description
 */

public interface ReplayService {

    List<Replay> getReplayListByID(String id);

    String insertReplay(Replay replay);

    int deleteReplay(String id);

    int cancelDeleteReplay(String id);
}