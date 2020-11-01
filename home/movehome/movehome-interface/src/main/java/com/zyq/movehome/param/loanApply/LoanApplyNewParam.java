package com.zyq.movehome.param.loanApply;

import lombok.Data;

import java.sql.Date;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/15 - 16:01
 */
@Data
public class LoanApplyNewParam {
    private String id;
    private String customerId;
    private String referrerName;
    private String referrerPhone;
    private String productType;
    private String enterpriseName;
    private String applicantName;
    private String applicantPhone;
    private Long loanAmount;
    private String timeLimit;
    private String purpose;
    private Date createTime;
    private String code;

}
