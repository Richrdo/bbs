package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableCharset;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.*;

import javax.persistence.Table;

/**
 * @ClassName Article
 * @Author CeaserBorgia
 * @Date 8:57 2019/12/16
 * @Description
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(name = "article")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class Article extends BaseBean {

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private boolean isMarrow=false;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.TINYINT, defaultValue = "0")
    private boolean isDelete=false;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String title=null;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.TINYINT, defaultValue = "0")
    private boolean isTop=false;
}

