package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableCharset;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.*;

import javax.persistence.Table;

/**
 * @ClassName Reward
 * @Author CeaserBorgia
 * @Date 8:58 2019/12/16
 * @Description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(name = "reward")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class Reward extends BaseBean {
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
    @Column(type = MySqlTypeConstant.INT)
    private int points=0;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String bestReplay;

}

