package com.zyq.movehome.controller;

import com.zyq.movehome.param.loanApply.LoanApplyNewParam;
import com.zyq.movehome.request.LoanApplyNewRequest;
import com.zyq.movehome.service.LoanApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/16 - 15:48
 */
@RestController
@RequestMapping("/loanApply")
public class LoanApplyController {
//   @Autowired
//    LoanApplyService loanApplyService;
//   @RequestMapping(value = "/add",method = RequestMethod.POST)
//    public int addLoanApply(@RequestBody LoanApplyNewRequest loanApplyNewRequest){
//       LoanApplyNewParam loanApplyNewParam = new LoanApplyNewParam();
//       BeanUtils.copyProperties(loanApplyNewRequest,loanApplyNewParam);
//      return loanApplyService.addLoanApply(loanApplyNewParam);
//   }
}
