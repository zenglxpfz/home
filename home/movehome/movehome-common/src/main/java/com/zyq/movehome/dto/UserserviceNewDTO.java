package com.zyq.movehome.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

public class UserserviceNewDTO implements Serializable {
    private Integer uid;
    @NotBlank(
            message = "System002"
    )
    private String uname;

    @NotBlank(
            message = "System003"
    )
    private String password;
    @NotBlank(
            message = "System004"
    )
    private String sex;
    @NotBlank(
            message = "System005"
    )
    private String email;

    @NotBlank(
            message = "System006"
    )
    private String identity;

    @NotBlank(
            message = "System007"
    )
    private String phone;

    private String status;
    @NotBlank(
            message = "System009"
    )
    private String birthday;

    private String signature;
    @NotBlank(
            message = "System010"
    )
    private String address;


    private String picture;

    private String code;

    private String role;

    private Date registrationtime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }
}