package com.zyq.movehome.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private Integer urid;

    private String role;

    public Integer getUrid() {
        return urid;
    }

    public void setUrid(Integer urid) {
        this.urid = urid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}