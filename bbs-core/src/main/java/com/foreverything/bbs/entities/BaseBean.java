package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName BaseBean
 * @Author CeaserBorgia
 * @Date 22:08 2019/12/15
 * @Description
 */

@Data
@ToString
public class BaseBean {
    @Getter
    @Setter
    @Column(isKey = true, isAutoIncrement = true, type = MySqlTypeConstant.BIGINT)
    private int id;

    @Getter
    @Setter
    @Column
    private String createTime;

    @Column(type = MySqlTypeConstant.INT, isNull = false)
    private int userId;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.TEXT)
    private String content;
}

