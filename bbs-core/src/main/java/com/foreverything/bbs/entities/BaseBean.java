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
    @Column(isKey = true,isAutoIncrement = true,type = MySqlTypeConstant.BIGINT)
    private String id;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String uuid;

    @Getter
    @Setter
    @Column
    private String userUuid;

    @Getter
    @Setter
    @Column
    private String createTime;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.TEXT)
    private String content;
}

