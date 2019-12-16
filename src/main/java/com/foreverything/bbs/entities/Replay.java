package com.foreverything.bbs.entities;

/**
 * @ClassName Replay
 * @Author CeaserBorgia
 * @Date 9:00 2019/12/16
 * @Description
 */

public class Replay extends BaseBean {
    private boolean isMarrow=false;
    private boolean isDelete=false;

    public boolean isMarrow() {
        return isMarrow;
    }

    public void setMarrow(boolean marrow) {
        isMarrow = marrow;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

}

