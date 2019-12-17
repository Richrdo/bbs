package com.foreverything.bbs.entities;

/**
 * @ClassName Replay
 * @Author CeaserBorgia
 * @Date 9:00 2019/12/16
 * @Description
 */

public class Replay extends BaseBean {

    private boolean isDelete=false;
    private Long fromID=null;

    public Long getFromID() {
        return fromID;
    }

    public void setFromID(Long fromID) {
        this.fromID = fromID;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

}

