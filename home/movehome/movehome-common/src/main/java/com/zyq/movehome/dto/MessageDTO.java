package com.zyq.movehome.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MessageDTO implements Serializable {
    private Integer mid;

    private Integer tid;

    private Integer uid;

    private String content;

    private String tname;

    private String uname;

    private Integer countpl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;

    private String status;

    private List<MhuifuDTO> mhuifuDTOS;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCountpl() {
        return countpl;
    }

    public void setCountpl(Integer countpl) {
        this.countpl = countpl;
    }

    public List<MhuifuDTO> getMhuifuDTOS() {
        return mhuifuDTOS;
    }

    public void setMhuifuDTOS(List<MhuifuDTO> mhuifuDTOS) {
        this.mhuifuDTOS = mhuifuDTOS;
    }



    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}