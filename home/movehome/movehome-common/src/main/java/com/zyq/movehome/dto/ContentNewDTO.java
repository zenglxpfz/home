package com.zyq.movehome.dto;

import java.io.Serializable;
import java.util.Date;

public class ContentNewDTO implements Serializable {
    private Integer cid;

    private String crules;

    private Integer tid;

    private Date createtime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCrules() {
        return crules;
    }

    public void setCrules(String crules) {
        this.crules = crules;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}