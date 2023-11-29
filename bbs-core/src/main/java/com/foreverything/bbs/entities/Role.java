package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableCharset;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@ToString
@Table(name = "role")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class Role {

    @Column(isKey = true, isAutoIncrement = true, type = MySqlTypeConstant.INT)
    private int id;

    /**
     * 用户角色类型
     * 0 超级管理员，用于最高权限，比如修改管理员等
     * 1 讨论区管理员，可以置顶、删除讨论区的帖子和评论
     * 2 文章区管理员，可以置顶、删除文章区的帖子和评论
     * 3 悬赏区管理员，可以置顶、删除悬赏区的帖子和评论
     * 4 普通用户，可以发表和删除自己的帖子
     */
    @Column(type = MySqlTypeConstant.INT, isNull = false)
    private int type;


    @Column(type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String name;
}
