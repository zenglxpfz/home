package com.zyq.movehome.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class NoticeDTO {
    private Integer bid;

    private String content;

    private String tital;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date crieatetime;

    private String username;

    private String status;

    private String type;

    private Integer uid;

    private String time;

    private UserDTO userDTO;

    private Integer countpl;

    public Integer getCountpl() {
        return countpl;
    }

    public void setCountpl(Integer countpl) {
        this.countpl = countpl;
    }

    private List<AppraisalDTO> appraisalDTOS;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<AppraisalDTO> getAppraisalDTOS() {
        return appraisalDTOS;
    }

    public void setAppraisalDTOS(List<AppraisalDTO> appraisalDTOS) {
        this.appraisalDTOS = appraisalDTOS;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }

    public Date getCrieatetime() {
        return crieatetime;
    }

    public void setCrieatetime(Date crieatetime) {
        this.crieatetime = crieatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}