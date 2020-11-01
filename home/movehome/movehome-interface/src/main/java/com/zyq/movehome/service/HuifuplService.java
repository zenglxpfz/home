package com.zyq.movehome.service;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.HuifuplDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:43
 */
public interface HuifuplService {

    MsgResult<Boolean> insert(HuifuplDTO huifuplDTO);

    //根据主键查询
    MsgResult<List<HuifuplDTO>> select(HuifuplDTO huifuplDTO);

    MsgResult<HuifuplDTO> selectBykey(Integer aid);

    MsgResult<Boolean> delect(Integer aid);
}
