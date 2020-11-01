package com.zyq.movehome.dto;

import java.io.Serializable;
import java.util.Date;

public class TeamNewDTO implements Serializable {
    private Integer tid;

    private String tname;

    private String siogans;

    private String code;

    private Date createtime;

    private Long tperson;

    private String status;

    private String tpicture;

    private String thonor;

    private Long twatch;

    private Long tlikes;

    private String taddress;

    private String trange;

    private Integer uid;

    private String temail;

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTduiz() {
        return tduiz;
    }

    public void setTduiz(String tduiz) {
        this.tduiz = tduiz;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    private String tduiz;

    private String tphone;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSiogans() {
        return siogans;
    }

    public void setSiogans(String siogans) {
        this.siogans = siogans;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getTperson() {
        return tperson;
    }

    public void setTperson(Long tperson) {
        this.tperson = tperson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTpicture() {
        return tpicture;
    }

    public void setTpicture(String tpicture) {
        this.tpicture = tpicture;
    }

    public String getThonor() {
        return thonor;
    }

    public void setThonor(String thonor) {
        this.thonor = thonor;
    }

    public Long getTwatch() {
        return twatch;
    }

    public void setTwatch(Long twatch) {
        this.twatch = twatch;
    }

    public Long getTlikes() {
        return tlikes;
    }

    public void setTlikes(Long tlikes) {
        this.tlikes = tlikes;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public String getTrange() {
        return trange;
    }

    public void setTrange(String trange) {
        this.trange = trange;
    }
}