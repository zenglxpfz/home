package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ApplyDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:43
 */
public interface ApplyService {

    MsgResult<Boolean> insert(ApplyDTO applyDTO);

    MsgResult<Boolean> update(ApplyDTO applyDTO);

    MsgResult<PageInfo<List<ApplyDTO>>> selectByname(ApplyDTO applyDTO);

    MsgResult<Boolean> delect(ApplyDTO applyDTO);
}
