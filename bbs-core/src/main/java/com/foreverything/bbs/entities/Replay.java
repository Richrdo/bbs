package com.foreverything.bbs.entities;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableCharset;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.*;

import javax.persistence.Table;

/**
 * @ClassName Replay
 * @Author CeaserBorgia
 * @Date 9:00 2019/12/16
 * @Description
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(name = "replay")
@TableCharset(MySqlCharsetConstant.UTF8MB4)
public class Replay extends BaseBean implements Comparable<Replay> {

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.TINYINT, defaultValue = "0")
    private boolean isDelete=false;

    @Getter
    @Setter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String fromId=null;

    @Setter
    @Getter
    @Column(type = MySqlTypeConstant.VARCHAR)
    private String fromType;

    @Override
    public int compareTo(Replay replay) {
        return this.getCreateTime().compareTo(replay.getCreateTime());
    }
}

