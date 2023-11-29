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
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class User {

    @Column(isKey = true, isAutoIncrement = true, type = MySqlTypeConstant.INT)
    private int id;

    @Column(type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String email;

    @Column(type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String name;

    @Column(type = MySqlTypeConstant.VARCHAR, isNull = false)
    private String password;

    @Column(type = MySqlTypeConstant.INT)
    private int points = 0;
}
