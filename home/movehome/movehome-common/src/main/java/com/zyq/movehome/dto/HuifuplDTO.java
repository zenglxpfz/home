package com.zyq.movehome.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HuifuplDTO {
    private Integer aid;

    private Integer fid;

    private String content;

    private Integer zid;

    private String type;

    private Integer useid;

    private Integer usedid;

    private String username;

    private String useredname;

    private String time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUseid() {
        return useid;
    }

    public void setUseid(Integer useid) {
        this.useid = useid;
    }

    public Integer getUsedid() {
        return usedid;
    }

    public void setUsedid(Integer usedid) {
        this.usedid = usedid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseredname() {
        return useredname;
    }

    public void setUseredname(String useredname) {
        this.useredname = useredname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}