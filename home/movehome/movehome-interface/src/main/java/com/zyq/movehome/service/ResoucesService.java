package com.zyq.movehome.service;


import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.ResoucesDTO;
import com.zyq.movehome.dto.ResoucesNewDTO;
import com.zyq.movehome.dto.TeamDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:47
 */
public interface ResoucesService {

    MsgResult<Boolean> addResouse(ResoucesNewDTO resoucesNewDTO);
    //根据资源id查询个别资源详情
    MsgResult<ResoucesDTO> selectone(Integer id);

    //分页查询所有的团队信息，给用户看的
    MsgResult<PageInfo<List<ResoucesDTO>>> selectResouceslist(Integer pn, Integer tid);

    MsgResult<Boolean> delect(ResoucesDTO resoucesDTO);

    MsgResult<Boolean> update(ResoucesDTO resoucesDTO);
}
