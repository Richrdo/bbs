package com.foreverything.bbs.entities;

/**
 * @ClassName Reward
 * @Author CeaserBorgia
 * @Date 8:58 2019/12/16
 * @Description
 */

public class Reward extends BaseBean {
    private boolean isMarrow=false;
    private boolean isDelete=false;
    private String title=null;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

