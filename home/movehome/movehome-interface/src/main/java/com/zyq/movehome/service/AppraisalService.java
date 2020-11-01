package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.AppraisalDTO;
import com.zyq.movehome.dto.AppraisalNewDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:44
 */
public interface AppraisalService {

    //添加评论
    MsgResult<Boolean> addAppraisal(AppraisalNewDTO appraisalNewDTO);

    //删除评论
    MsgResult<Boolean> delete(Integer aid);

    //后台根据所有查询评论
    MsgResult<PageInfo<List<AppraisalDTO>>> selectAll(Integer pn);
    //查询该订单的评论
    MsgResult<List<AppraisalDTO>> selectByoid(Integer oid);

    MsgResult<Boolean> delect(AppraisalDTO appraisalDTO);


    //查询该订单的评论
    MsgResult<List<AppraisalDTO>> selectByZid(Integer zid);

}
