package com.foreverything.bbs.entities;

/**
 * @ClassName BaseBean
 * @Author CeaserBorgia
 * @Date 22:08 2019/12/15
 * @Description
 */

public class BaseBean {

    private Long id;
    private int userID;
    private String createTime;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

