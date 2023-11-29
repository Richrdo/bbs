package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableCharset;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;

@Data
@ToString
@Table(name = "user_role")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class UserRole {

    @Column(type = MySqlTypeConstant.INT, isNull = false)
    private int user_id;

    @Column(type = MySqlTypeConstant.INT, isNull = false)
    private int role_id;
}
