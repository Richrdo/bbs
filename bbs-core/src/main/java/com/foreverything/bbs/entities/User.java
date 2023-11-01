package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableCharset;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;

/**
 * @ClassName User
 * @Author LiuJingxin
 * @Date Created in 14:46 2019/12/17
 * @Description
 */
@Data
@ToString
@Table(name = "user")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class User {

    @Getter
    @Setter
    @Column(isKey = true, isAutoIncrement = true, type = MySqlTypeConstant.INT)
    private int id;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String password;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR, isKey = true)
    private String email;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.INT)
    private int grade = 0;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.TINYINT, defaultValue = "0")
    private boolean isAdmin = false;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String name;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String uuid;
}
