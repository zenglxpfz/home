package com.zyq.movehome.dto.loanApply;

import lombok.Data;

import java.util.Date;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/15 - 16:25
 */
@Data
public class VerifyCodeGetDTO {
    private String id;
    private String phone;
    private String code;
    private Date createTime;
    private Integer time;
}
