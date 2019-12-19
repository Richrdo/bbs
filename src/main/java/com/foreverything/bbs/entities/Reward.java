package com.foreverything.bbs.entities;

/**
 * @ClassName Reward
 * @Author CeaserBorgia
 * @Date 8:58 2019/12/16
 * @Description
 */

public class Reward extends BaseBean {
    private boolean isDelete=false;
    private String title=null;
    private int points=0;
    private long bestreplay;

    public long getBestreplay() {
        return bestreplay;
    }

    public void setBestreplay(long bestreplay) {
        this.bestreplay = bestreplay;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

