package com.foreverything.bbs.entities;

/**
 * @ClassName Article
 * @Author CeaserBorgia
 * @Date 8:57 2019/12/16
 * @Description
 */

public class Article extends BaseBean {
    private boolean isMarrow=false;
    private boolean isDelete=false;
    private String title=null;

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' + "content="+getContent()+
                '}';
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    private boolean isTop=false;

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

