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
 * @ClassName Topic
 * @Author CeaserBorgia
 * @Date 22:00 2019/12/15
 * @Description
 */

@Data
@ToString
@Table(name = "topic")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class Topic extends BaseBean{

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.BLOB)
     private boolean isMarrow=false;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.BLOB)
     private boolean isDelete=false;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
     private String title=null;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.BLOB)
     private boolean isTop=false;

}

