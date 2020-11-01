package com.zyq.movehome.dto;

import java.util.Date;

public class followNewDTO {
    private String id;

    private String loanApplyId;

    private String followUserid;

    private Date followTime;

    private String content;

    private String fssUids;

    private Date nextFollowTime;

    private Date createdTime;

    private String followType;

    private String journalId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanApplyId() {
        return loanApplyId;
    }

    public void setLoanApplyId(String loanApplyId) {
        this.loanApplyId = loanApplyId;
    }

    public String getFollowUserid() {
        return followUserid;
    }

    public void setFollowUserid(String followUserid) {
        this.followUserid = followUserid;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFssUids() {
        return fssUids;
    }

    public void setFssUids(String fssUids) {
        this.fssUids = fssUids;
    }

    public Date getNextFollowTime() {
        return nextFollowTime;
    }

    public void setNextFollowTime(Date nextFollowTime) {
        this.nextFollowTime = nextFollowTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getJournalId() {
        return journalId;
    }
}
