package com.zyq.movehome.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TeamDTO implements Serializable {
    private Integer tid;

    private String tname;

    private List<UserserviceDTO> userserviceDTOs;

    private List<ResoucesDTO> resoucesDTOS;

    private List<ContentDTO> contentDTOS;

    private Integer orders;

    private String siogans;

    private String code;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createtime;

    private Long tperson;

    private String status;

    private String tpicture;

    private String thonor;

    private Long twatch;

    private Long tlikes;

    private String taddress;

    private String trange;

    private List<String> tnames;

    private String temail;

    private List<Integer> tids;

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public List<UserserviceDTO> getUserserviceDTOs() {
        return userserviceDTOs;
    }

    public void setUserserviceDTOs(List<UserserviceDTO> userserviceDTOs) {
        this.userserviceDTOs = userserviceDTOs;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }


    public List<ResoucesDTO> getResoucesDTOS() {
        return resoucesDTOS;
    }

    public void setResoucesDTOS(List<ResoucesDTO> resoucesDTOS) {
        this.resoucesDTOS = resoucesDTOS;
    }

    public List<ContentDTO> getContentDTOS() {
        return contentDTOS;
    }

    public void setContentDTOS(List<ContentDTO> contentDTOS) {
        this.contentDTOS = contentDTOS;
    }

    public void setTnames(List<String> tnames) {
        this.tnames = tnames;
    }

    public void setDuizhangname(String duizhangname) {
        this.duizhangname = duizhangname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String tduiz;

    private String tphone;

    //创建时队长id
    private Integer uid;

    private String duizhangname;
    private String phone ;

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

    public List<String> getTnames() {
        return tnames;
    }

    public String getDuizhangname() {
        return duizhangname;
    }

    public String getPhone() {
        return phone;
    }



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

    public List<Integer> getTids() {
        return tids;
    }

    public void setTids(List<Integer> tids) {
        this.tids = tids;
    }
}