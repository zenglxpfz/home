package com.zyq.movehome.service;


import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.SouDTO;
import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.dto.UserserviceDTO;
import com.zyq.movehome.dto.UserserviceNewDTO;

import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:49
 */
public interface UserserviceService {

    MsgResult<Boolean> addUserservice(UserserviceNewDTO userserviceNewDTO);

    List<UserserviceDTO> selectListUserservice(UserserviceDTO userserviceDTO);

    UserserviceDTO selectUserserviceBynameAndpassword(UserserviceDTO userserviceDTO);

    MsgResult<Boolean> update(UserserviceDTO userserviceDTO);

    MsgResult<PageInfo<List<UserserviceDTO>>> selectUserserviceList(Integer pn);

    MsgResult<Boolean> delect(UserserviceDTO userserviceDTO);

    MsgResult<UserserviceDTO> selectOne(Integer uid);

    MsgResult<List<UserserviceDTO>> selectNullcode();

    MsgResult<List<UserserviceDTO>> selectbykey(SouDTO souDTO);
}
