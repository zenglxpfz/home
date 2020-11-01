package com.zyq.movehome.param;

import lombok.Data;

import java.util.Date;

@Data
public class UserNewParam {


    private Integer uid;

    private String uname;

    private String password;

    private String sex;

    private String email;

    private String identity;

    private String phone;

    private String status;

    private String birthday;

    private String signature;

    private String address;

    private Date registrationtime;

   }