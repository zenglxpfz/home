package com.zyq.movehome.dto;

import lombok.Data;
import springfox.documentation.schema.TypeNameExtractor;

import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/3/11 - 10:24
 */
@Data
public class TorderTeamResult implements Serializable {
    private String tname;
    private Integer count;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
