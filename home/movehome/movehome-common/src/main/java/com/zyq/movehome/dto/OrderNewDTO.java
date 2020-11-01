package com.zyq.movehome.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderNewDTO implements Serializable {
    private Integer oid;

    private String tname;

    private String uname;

    private String mtitle;

    private String mbegin;

    private String mend;

    private Date mtime;

    private String mattention;

    private Long amount;

    private String payfor;

    private String status;

    private Date createtime;

    private Date finishtime;

    private String scoring;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMbegin() {
        return mbegin;
    }

    public void setMbegin(String mbegin) {
        this.mbegin = mbegin;
    }

    public String getMend() {
        return mend;
    }

    public void setMend(String mend) {
        this.mend = mend;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getMattention() {
        return mattention;
    }

    public void setMattention(String mattention) {
        this.mattention = mattention;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPayfor() {
        return payfor;
    }

    public void setPayfor(String payfor) {
        this.payfor = payfor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring;
    }
}