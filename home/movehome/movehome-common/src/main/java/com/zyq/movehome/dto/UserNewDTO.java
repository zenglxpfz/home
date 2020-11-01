package com.zyq.movehome.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
@Data
public class UserNewDTO implements Serializable {


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

    private Date registrationtime;

   }