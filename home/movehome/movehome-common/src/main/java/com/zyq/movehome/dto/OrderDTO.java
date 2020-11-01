package com.zyq.movehome.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable {
    private Integer oid;

    private String tname;

    private String uname;

    private String mtitle;

    private String mbegin;

    private String mend;

    private Integer pn;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date mtime;

    private String mattention;

    private Long amount;

    private String payfor;

    private String status;

    private String type;

    private Integer countpl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date finishtime;

    private String scoring;

    private List<AppraisalDTO> appraisalDTOS;

    public Integer getCountpl() {
        return countpl;
    }

    public void setCountpl(Integer countpl) {
        this.countpl = countpl;
    }



    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AppraisalDTO> getAppraisalDTOS() {
        return appraisalDTOS;
    }

    public void setAppraisalDTOS(List<AppraisalDTO> appraisalDTOS) {
        this.appraisalDTOS = appraisalDTOS;
    }

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