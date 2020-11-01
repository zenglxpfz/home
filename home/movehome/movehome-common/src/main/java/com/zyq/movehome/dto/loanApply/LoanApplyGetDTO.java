package com.zyq.movehome.dto.loanApply;

import lombok.Data;

import java.sql.Date;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/15 - 16:13
 */
@Data
public class LoanApplyGetDTO {
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
}
