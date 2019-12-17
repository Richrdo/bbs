package com.foreverything.bbs.entities;

/**
 * @ClassName Topic
 * @Author CeaserBorgia
 * @Date 22:00 2019/12/15
 * @Description
 */

public class Topic extends BaseBean{
     private boolean isMarrow=false;
     private boolean isDelete=false;
     private String title=null;
     private boolean isTop=false;

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

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

