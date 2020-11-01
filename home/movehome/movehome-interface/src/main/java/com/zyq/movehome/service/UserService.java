package com.zyq.movehome.service;

import com.github.pagehelper.PageInfo;
import com.zyq.movehome.common.MsgResult;
import com.zyq.movehome.dto.UserDTO;
import com.zyq.movehome.dto.UserNewDTO;
import com.zyq.movehome.dto.UserserviceDTO;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 1:49
 */
public interface UserService {

    MsgResult<Boolean> addUser(UserNewDTO userNewDTO);

    MsgResult<PageInfo<List<UserDTO>>> selectUserList(Integer pn);

    UserDTO selectUserBynameAndpassword(UserDTO userDTO);

    MsgResult<Boolean> update(UserDTO userDTO);

    MsgResult<UserDTO> selectUserByUid(UserDTO userDTO);

    MsgResult<Boolean> delect(UserDTO userDTO);
}
