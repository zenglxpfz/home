package com.zyq.movehome.service;

import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.HuifuplDTO;
import com.zyq.movehome.dto.MhuifuDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:43
 */
public interface MhuifuService {

    MsgResult<Boolean> insert(MhuifuDTO huifupDTO);

    //根据主键查询
    MsgResult<List<MhuifuDTO>> select(MhuifuDTO huifuplDTO);

    MsgResult<MhuifuDTO> selectBykey(Integer aid);

    MsgResult<Boolean> delect(Integer mid);
}
