package com.zyq.movehome.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/3/10 - 12:43
 */
@Data
public class LoginDTO implements Serializable {
    private String uname;
    private String password;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
